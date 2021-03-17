package com.wei.service.event.entity;

import lombok.Data;

@Data
public class OutParam {
    /**
     * 当前索引
     */
    private int currentIndex;
    /**
     * 说明
     */
    private String remark;
    /**
     * 结果
     */
    private Object result;
}
