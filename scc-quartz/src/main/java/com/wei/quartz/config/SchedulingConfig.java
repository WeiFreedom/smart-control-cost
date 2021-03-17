package com.wei.quartz.config;

import com.wei.utils.constant.AppConstant;
import com.wei.utils.exception.WorkingException;
import com.wei.quartz.schedule.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 第二种方式 动态创建定时任务
 * 需要的类
 * SchedulingConfig
 * ScheduledTask
 * ScheduledTaskImpl
 * ScheduledEntity
 * 来源: https://zhuanlan.zhihu.com/p/79644891
 * entityList 这个类可以从数据库里面查 目前先写死了
 */
//@Configuration
public class SchedulingConfig implements SchedulingConfigurer {

   public static List<ScheduleEntity> entityList = new ArrayList<ScheduleEntity>() {
        {
            add(new ScheduleEntity() {
                {
                    setClassName("com.wei.quuartz.schedule.ScheduledTaskImpl");
                    setCron("0/2 * * * * ?");
                    setStatus(AppConstant.Y);
                }
            });
        }
    };
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        for (ScheduleEntity entity : entityList) {

            Class<?> clazz = null;
            Object task = null;
            try {
                clazz = Class.forName(entity.getClassName());
                task = applicationContext.getBean(clazz);
            } catch (Exception ex) {
                throw new WorkingException("任务管理配置失败!", ex);
            }

            scheduledTaskRegistrar.addTriggerTask((Runnable) task, triggerContext ->{
                return new CronTrigger(entity.getCron()).nextExecutionTime(triggerContext);
            });
        }
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(1);
    }
}
