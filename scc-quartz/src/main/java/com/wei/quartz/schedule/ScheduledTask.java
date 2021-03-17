package com.wei.quartz.schedule;

import com.wei.utils.constant.AppConstant;
import com.wei.quartz.config.SchedulingConfig;

public interface ScheduledTask extends Runnable {

    void execute();

    @Override
    default void run() {
        if(this.getClass().getName().equals(SchedulingConfig.entityList.get(0).getClassName())){
            if(SchedulingConfig.entityList.get(0).getStatus().equals(AppConstant.N)){
                return;
            }
        }
        execute();
    }
}
