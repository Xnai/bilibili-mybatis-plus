package com.mp.study.bilibilimybatisplus.handler;
/**
 * 用于实体类自动填充的字段，insertFill在新增时触发，updateFill在更新时触发
 * metaObject是执行的对象
 * 在实体类的 fill=FieldFill.XXXX 时调用
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // insert时触发
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    // update时触发
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
