package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_card")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 号码
     */
    private String cardNo;

    /**
     * 病人id
     */
    private Integer ptId;

    /**
     * 01 微信号 02 QQ号 03 微博号
     */
    private String cardType;

    /**
     * 更新时间
     */
    private LocalDateTime modDt;

    /**
     * 更新人编码
     */
    private String modCode;


}
