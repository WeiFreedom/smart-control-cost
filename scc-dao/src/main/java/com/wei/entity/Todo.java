package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wei
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_todo")
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer todoId;

    /**
     * 医生编码
     */
    private String drCode;

    /**
     * 完成状态 Y 已完成 N 未完成
     */
    private String todoState;

    /**
     * 删除状态 Y 已删除 N 未删除
     */
    private String todoFlag;

    /**
     * 操作时间
     */
    private Date todoTime;

    /**
     * 待办内容
     */
    private String todoContent;


}
