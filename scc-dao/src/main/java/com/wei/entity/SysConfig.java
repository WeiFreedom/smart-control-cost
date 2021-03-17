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
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_sys_config")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "tc_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编码
     */
    private String sysCode;

    /**
     * 备注
     */
    private String sysRemark;

    /**
     * int类型配置
     */
    private Integer sysNumber;

    /**
     * decimal类型配置
     */
    private BigDecimal sysDecimal;

    /**
     * datetime类型配置
     */
    private LocalDateTime sysDate;

    /**
     * 字符类型配置
     */
    private String sysStr;


}
