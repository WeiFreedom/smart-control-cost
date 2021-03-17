package com.wei.quartz.trigger;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzTrigger {
    private String triggerName = "threeMinuteTrigger";
    private String triggerGroup = "threeMinuteTriggerGroup";
    private Integer interval = 1000*2;//3 *1000 * 60;

    @Bean
    public Trigger getTrigger(){
        return   TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey(triggerName, triggerGroup))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMilliseconds(interval)
                        .repeatForever())
                .startNow()
                .build();
    }
}
