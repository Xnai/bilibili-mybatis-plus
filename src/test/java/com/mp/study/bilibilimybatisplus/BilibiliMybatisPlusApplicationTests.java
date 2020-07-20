package com.mp.study.bilibilimybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.study.bilibilimybatisplus.entity.User;
import com.mp.study.bilibilimybatisplus.enums.AgeEnum;
import com.mp.study.bilibilimybatisplus.mapper.UserMapper;
import com.mp.study.bilibilimybatisplus.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BilibiliMybatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void insert1() {
        User user = new User();
        user.setId(3);
        user.setTitle("王五");
        //user.setAge(20);
        userMapper.insert(user);
    }

    @Test
    void selectList1() {
        userMapper.selectList(null).forEach(System.out::println );
        /**
         * 当使用了@TableLogic 注解逻辑删除时，逻辑已为删除的数据不会被查出，
         */
    }

    @Test
    void update1() {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("F_ID", 2));
        user.setTitle("李信");
        userMapper.updateById(user);
    }

    @Test
    void delete() {
        userMapper.deleteById(1);
    }

    @Test
    void select() {

        //userMapper.selectList(null); // 不加任何条件，查询全部，注意逻辑删除字段的设定
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("f_name","李信");
//        userMapper.selectList(wrapper).forEach(System.out::println);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("f_name","李信");
//        userMapper.selectByMap(map); // map只能做等值查询，不能做逻辑判断，想使用逻辑判断要使用wrapper



//        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);//将查询的结果集封装到map中，返回的是一个map列表
        // //       maps.forEach(System.out::println);

         //分页查询： 需要添加配置在配置类中添加paginationInterceptor
//        Page<User> page = new Page<>(1,3);
//        Page<User> userPage = userMapper.selectPage(page, null);
//        System.out.println("当前页：" + userPage.getCurrent() + "\n" +
//            "总记录数：" + userPage.getTotal() + "\n" +
//                "每页条目数量：" + userPage.getSize() +"\n" +
//                "记录内容：" + userPage.getRecords());

//        Page<Map<String, Object>> page =  new Page(1,2);
//        Page<Map<String, Object>> mapPage = userMapper.selectMapsPage(page, null);// 将查询的记录封装成一个map列表
//
//        System.out.println("当前页：" + mapPage.getCurrent() + "\n" +
//            "总记录数：" + mapPage.getTotal() + "\n" +
//                "每页条目数量：" + mapPage.getSize() +"\n" +
//                "总页数：" + mapPage.getPages() + "\n" +
//                "记录内容：" + mapPage.getRecords());


            // 查询符合条件的记录的主键
            //userMapper.selectObjs(null).forEach(System.out::println);

            // 查询单条，只有保证查询结果为单条时才可以使用，不然会报错
            //userMapper.selectOne(warpper);

    }

    @Test
    void selectManyTable() {
        // 自定义sql(多表关联查询)

        //将sql语句的结果集映射到 ProductVO 中
        //SELECT t2.*,t1.F_ID,t1.F_NAME FROM T_USER t1, T_PRODUCT t2 where t2.F_USER_ID=t1.F_ID AND t1.F_ID=1;

        //1.在mapper中写自定义的方法，写sql
        List<ProductVO> vos = userMapper.porductList(2);
        System.out.println(vos.size() + "," + vos.get(1) + "\n" + vos.get(0));

    }


    @Test
    void delete1() {
        userMapper.deleteBatchIds(Arrays.asList(1,2));

        QueryWrapper<User> wrapper =  new QueryWrapper<>();
        wrapper.eq("f_age",20);
        userMapper.delete(wrapper); // 将查询条件放在wrapper中

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("f_id", 3);

        userMapper.deleteByMap(map); // 将查询条件放在map猴子那个
    }

    @Test
    void update() {
//        User user = userMapper.selectById(2);
//        user.setAge(AgeEnum.TWENTY_SERVEN);
//        userMapper.updateById(user);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("f_age",25);
        User user1 = new User();
        user1.setTitle("王也");
        userMapper.update(user1, wrapper); // 第一个参数为要修改的值，第二个参数为where条件生成的依据
    }
}
