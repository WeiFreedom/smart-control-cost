package com.wei.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class QuartzJob implements Job {

    /**
     * 第三种方式 quartz
     * 需要的类
     * QuartzJob
     * QuartzJobDetail
     * StartScheduler
     * QuartzTrigger
     * 在这个里面写代码执行的逻辑
     * 需要注意的是 QuartJob 是Quart框架帮我们创建的,所以无法使用@Autowired注入Spring IOC中的bean对象
     * 需要使用SpringApplicationContextUtils帮我们拿到IOC中的对象
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz>>"+ new Date());
    }
}
