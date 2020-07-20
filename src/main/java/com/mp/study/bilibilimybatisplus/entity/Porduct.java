package com.mp.study.bilibilimybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("T_PRODUCT")
public class Porduct {

    @TableId("F_ID")
    private Integer category;

    @TableField("F_COUNT")
    private Integer count;

    @TableField("F_DESCRIPTION")
    private String description;

    @TableField("F_USER_ID")
    private Integer userId;  // 逻辑关联用户的字段

}
