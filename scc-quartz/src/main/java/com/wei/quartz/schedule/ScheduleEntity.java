package com.wei.quartz.schedule;

import lombok.Data;

@Data
public class ScheduleEntity {
    /**
     * 类名
     */
    private String className;
    /**
     * cron表达式
     */
    private String cron;
    /**
     * 状态
     */
    private String status;
}
