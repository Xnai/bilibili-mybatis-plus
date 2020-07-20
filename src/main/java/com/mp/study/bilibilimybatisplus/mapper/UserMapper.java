package com.mp.study.bilibilimybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mp.study.bilibilimybatisplus.entity.User;
import com.mp.study.bilibilimybatisplus.vo.ProductVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    // 自定义sql，包括操作多表联查等
    @Select("SELECT t2.F_CATEGORY as category,t2.F_COUNT as count,t2.F_DESCRIPTION as description,t1.F_ID as userId,t1.F_NAME as userName FROM T_USER t1, T_PRODUCT t2 where t2.F_USER_ID=t1.F_ID AND t1.F_ID=#{id}")
    List<ProductVO> porductList(Integer id);


}
