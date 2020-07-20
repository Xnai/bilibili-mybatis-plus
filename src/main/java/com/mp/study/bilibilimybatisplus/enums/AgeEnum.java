package com.mp.study.bilibilimybatisplus.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 通过实现接口的方式完成枚举类的映射
 */


public enum AgeEnum implements IEnum<Integer> {
    TWEENY(20,"年轻人"),
    TWENTY_TWO(22,"青年"),
    TWENTY_FIVE(25,"老汉"),
    TWENTY_SERVEN(27,"入土");

    private Integer code;
    private String msg;

    AgeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override // 通过实现的此方法，找到应和数据库字段值对应的实体类的属性
    public Integer getValue() {
        return this.code;
    }
}
