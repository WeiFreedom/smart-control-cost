package com.wei.entity;

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
@TableName("tb_hos_dic")
public class HosDic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "tc_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 上级编码
     */
    private String parentCode;

    /**
     * 拼音
     */
    private String py;

    /**
     * 备注
     */
    private String remark;

    /**
     * 修改时间
     */
    private LocalDateTime modDt;

    /**
     * 修改人编码
     */
    private Integer modCode;


}
