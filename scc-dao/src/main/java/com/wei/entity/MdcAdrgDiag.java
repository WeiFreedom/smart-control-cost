package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_mdc_adrg_diag")
public class MdcAdrgDiag {
    /**
     * 核心诊断相关分组相关操作编码
     */
    private String adrgCode;
    /**
     *诊断类型 见字典AC
     */
    private String diagType;
    /**
     * 诊断字典编码/操作编码
     */
    private String diagCode;
    /**
     * 诊断字典名称/操作名称
     */
    private String diagName;
    /**
     * 分组
     */
    private int adrgCondition;
}
