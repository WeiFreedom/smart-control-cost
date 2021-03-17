package com.wei.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wei
 * @since 2021-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_pt_visit")
public class PtVisit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "tc_visit_id", type = IdType.AUTO)
    private Integer visitId;

    /**
     * 就诊次数
     */
    private Integer visitSeries;

    /**
     * 病人id
     */
    private Integer ptId;

    /**
     * 门诊0 住院1 急诊2 体检 3
     */
    private String visitType;

    /**
     * 病人姓名
     */
    private String ptName;

    /**
     * 挂号科室编码
     */
    private String visitDeptCode;

    /**
     * 挂号科室名称
     */
    private String visitDeptName;

    /**
     * 挂号时间
     */
    private LocalDateTime visitTime;

    /**
     * 状态1 已挂号 2 已退号
     */
    private String visitStatus;

    /**
     * 挂号医生
     */
    private String drCode;

    /**
     * 操作人
     */
    private String optCode;

    /**
     * 退号时间
     */
    private LocalDateTime backTime;

    /**
     * 总挂号金额
     */
    private BigDecimal registerFee;

    /**
     * 0 未就诊 1 已就诊
     */
    private String medicalStatus;

    /**
     * 就诊时间
     */
    private LocalDateTime medicalTime;

    /**
     * 医保类型 字典类型AA
     */
    private String miType;

    /**
     * 慢病类型
     */
    private String chronicType;

    /**
     * 特殊病类型
     */
    private String specialType;

    /**
     * 绿色通道
     */
    private String greenChannel;

    /**
     * icd10诊断名称
     */
    private String diagnoseName;

    /**
     * icd10诊断编码
     */
    private String diagnoseCode;
    /**
     * 病种类型 字典类型AB
     */
    private String diseaseType;
}
