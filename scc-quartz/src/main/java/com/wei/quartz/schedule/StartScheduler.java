package com.wei.quartz.schedule;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class StartScheduler {
    @Autowired
    private Trigger trigger;
    @Autowired
    private JobDetail job;

    public void start() throws Exception{
        SchedulerFactory schedulerfactory= new StdSchedulerFactory();
        Scheduler scheduler= schedulerfactory.getScheduler();
        scheduler.scheduleJob(job,  trigger);
        scheduler.start();
    }
}
