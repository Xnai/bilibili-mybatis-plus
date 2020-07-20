package com.mp.study.bilibilimybatisplus.enums;

/**
 * 通过注解的方式完成映射
 *
 * @EnumValue 将数据库的值映射为枚举对象
 */

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    WORK(1,"上班"),
    REST(0,"休息");

    @EnumValue // 在此处使用@EnumValue注解，因为该实体属性与数据库字段值映射
    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
