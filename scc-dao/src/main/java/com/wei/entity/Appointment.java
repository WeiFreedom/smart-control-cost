package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 预约
 * </p>
 *
 * @author wei
 * @since 2021-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约主键
     */
    @TableId(value = "tc_appoint_id", type = IdType.AUTO)
    private Integer appointId;

    /**
     * 排班id
     */
    private Integer appointScheId;

    /**
     * 预约姓名
     */
    private String appointName;

    /**
     * 患者id
     */
    private Integer appoinitPtId;

    /**
     * 预约门诊号
     */
    private String appointIoNo;

    /**
     * 预约号,可以自己产生,也可以第三方产生
     */
    private String appointNo;

    /**
     * 预约手机号码
     */
    private String appointPhone;

    /**
     * 预约医生
     */
    private String appointDrCode;

    /**
     * 预约科室
     */
    private String appointDeptCode;

    /**
     * 上午 1 下午 2 晚上 3
     */
    private String appointApn;

    /**
     * 预约时间
     */
    private LocalDate appointDate;

    /**
     * 具体时间 11:25
     */
    private String appointTime;

    /**
     * 预约状态 取消4 已预约1 已使用2
     */
    private String appointState;

    /**
     * 预约来源
     */
    private String appointUseType;

    /**
     * 预约来源名称
     */
    private String appointUseName;

    /**
     * 操作时间
     */
    private LocalDateTime appointCreateDate;

    /**
     * 取消时间
     */
    private LocalDateTime appointCancelDate;

    /**
     * 是否爽约
     */
    private String appointBlacklist;

    /**
     * 预约操作人
     */
    private String appointOptCode;

    /**
     * 取消预约操作人
     */
    private String appointCancalOptCode;

    /**
     * 号源id
     */
    private Integer schedulingDetailId;


}
