package com.mp.study.bilibilimybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.mp.study.bilibilimybatisplus.enums.AgeEnum;
import com.mp.study.bilibilimybatisplus.enums.StatusEnum;
import lombok.Data;
import java.util.Date;

@Data
@TableName("T_USER")
public class User {

    @TableId(value="F_ID")
    private Integer id;

    @TableField(value = "F_NAME")
    private String title;

    //@TableField(select = false, value = "F_AGE") // 有select=false 时，查询时不会查询该字段
    @TableField(value = "F_AGE")
    private AgeEnum age;

    @TableField(value = "F_CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "F_UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version  // 此注解相当于在执行update时，标记一个乐观锁，在执行时会将当前的version作为条件，并在设定值时，将 version+1 ，避免了重复修改
    private Integer version; // 需要配置类OptimisticLockerInterceptor相结合完成功能

    @TableField(exist = false) // 表名此属性只存在于实体类而不存在与数据库表中
    private String flag;

    @TableField("F_STATUS")
    private StatusEnum status; // 使用枚举类，将数据库的数字转换为对应的翻译  还需要在配置文件yml中，加入配置： mybatiss-plus:type-enums-package: 包名

                 // 需要在yml配置文件中加入配置： mybatis-plus:global-config:db-config:logic-not-delete-value:0
    @TableLogic  // 需要在yml配置文件中加入配置： mybatis-plus:global-config:db-config:logic-delete-value:1
    @TableField("F_IS_DELETE")
    private Integer isDelete; // 为未删除，1为已删除 用于逻辑删除（假删除)
}
