package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wei
 * @since 2021-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科室ID
     */
    @TableId(value = "tc_dept_id", type = IdType.AUTO)
    private Integer deptId;

    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 拼音
     */
    private String deptPinyin;

    /**
     * 科室电话
     */
    private String deptPhone;

    /**
     * 上级ID
     */
    private String deptParentCode;

    /**
     * 排序
     */
    private Integer deptSort;

    /**
     * 科室介绍
     */
    private String deptIntroduce;

    /**
     * 科室地址
     */
    private String deptAddress;

    /**
     * 科室分类编码
     */
    private String deptTypeCode;

    /**
     * 科室分类名称
     */
    private String deptTypeName;

    /**
     * 门诊0 住院1 急诊2
     */
    private String deptFeatures;

    /**
     * 使用状态Y 再用 N停用
     */
    private String deptState;


}
