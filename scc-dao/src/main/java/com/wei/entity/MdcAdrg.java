package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_mdc_adrg")
public class MdcAdrg {
    private String mdcCode;
    private String adrgCode;
    private String adrgName;
    private String adrgCondition;
}
