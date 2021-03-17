package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 诊断字典表
 * </p>
 *
 * @author wei
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_disease")
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 诊断编码
     */
    private String diagCode;

    /**
     * 诊断名称
     */
    private String diagName;

    /**
     * 诊断类型 见字典AC
     */
    private String diagType;

    /**
     * 诊断上级编码
     */
    private String diagParentCode;

    /**
     * 诊断助记码
     */
    private String diagPinyin;

    /**
     * 适用性别
     */
    private String sex;

    /**
     * 是否是手术 Y是手术 N不是手术
     */
    private String operFlag;


}
