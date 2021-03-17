package com.wei.quartz.schedule;

import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class ScheduledTaskImpl implements ScheduledTask {
    @Override
    public void execute() {
        System.out.println("动态执行任务>>>"+ new Date());
    }
}
