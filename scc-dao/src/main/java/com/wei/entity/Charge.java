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
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_charge")
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用id
     */
    @TableId(value = "tc_charge_id", type = IdType.AUTO)
    private Integer chargeId;

    /**
     * 门诊0 住院1 急诊2 体检 3
     */
    private String chargeType;

    /**
     * 就诊id
     */
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
     * 处方号
     */
    private Integer prescriptionId;

    /**
     * 费用分类 见字典A2
     */
    private String type;

    /**
     * 费用编码
     */
    private String chargeCode;

    /**
     * 费用名称
     */
    private String chargeName;

    /**
     * 规格
     */
    private String feeSpecification;

    /**
     * 销售单位
     */
    private String feeUnitCode;

    /**
     * 销售单位名称
     */
    private String feeUnitName;

    /**
     * 剂量单位
     */
    private String feeDoseUnit;

    /**
     * 包装单位
     */
    private String feePackunit;

    /**
     * 单价
     */
    private BigDecimal fee;

    /**
     * 数量
     */
    private BigDecimal chargeAmount;

    /**
     * 总价
     */
    private BigDecimal feeSum;

    /**
     * 发票总表id
     */
    private Integer mainId;

    /**
     * 结算状态 0 未结算 1 已结算 4 已退费
     */
    private String feeStatus;

    /**
     * 开单科室
     */
    private String applyDeptCode;

    /**
     * 执行科室
     */
    private String execDeptCode;

    /**
     * 费用产生时间
     */
    private LocalDateTime chargeDate;

    /**
     * 开单时间
     */
    private LocalDateTime applyTime;

    /**
     * 执行时间
     */
    private LocalDateTime execTime;

    /**
     * 执行状态 0 未执行 1 已执行 4 已取消
     */
    private String execStatus;

    /**
     * 结算时间
     */
    private LocalDateTime chargeTime;


}
