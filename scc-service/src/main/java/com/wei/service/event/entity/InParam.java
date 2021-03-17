package com.wei.service.event.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InParam {
    /**
     * 主诊断编码
     */
    private String mainDiagnosisCode;
    /**
     * 次诊断编码
     */
    private String nextDiagnosisCode;
    /**
     * 手术编码
     */
    private String operationCode;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄(岁)
     */
    private int age;

    /**
     * 新生儿年龄(天)
     */
    private int newbornAge;
    /**
     * 新生儿体重
     */
    private float newbornWeight;
    /**
     * 住院天数
     */
    private int daysStay;
    /**
     * 住院费用
     */
    private BigDecimal chargeStay;
    /**
     * 离院方式 5 正常遗嘱 7 死亡/转院 9 不区分
     */
    private String leavingWay;
}
