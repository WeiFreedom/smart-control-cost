package com.wei.dto;

import lombok.Data;

@Data
public class VerifyPageMedicalRecordDto {
    /**
     * 姓名
     */
    private String ptName;
    /**
     * 病案号
     */
    private String ptMedicalNo;
    /**
     * 科室
     */
    private String deptName;
    /**
     * 主要诊断编码
     */
    private String diagCode;
    /**
     * 主要手术编码
     */
    private String operCode;
    /**
     * 科室名称
     */
    private String drName;
    /**
     * 出院日期
     */
    private String outDate;
    /**
     * 主诊断编码验证
     */
    private String verifyDiag;
    /**
     * 主要手术编码验证
     */
    private String verifyOper;
    /**
     * 其他手术编码验证
     */
    private String verifyOtherOper;
    /**
     * 主要诊断与主要手术匹配合理性
     */
    private String verifyRationality;
}
