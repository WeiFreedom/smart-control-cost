package com.wei.quartz.schedule;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * 第一种方式创建定时任务
 * 但是存在的弊端是 服务起来之后重新调整任务就必须得调整代码了
 * 还需要在main函数上增加@EnableScheduling
 */
//@Component
public class SpringbootSchedule {

    @Scheduled(fixedRate = 2000)
    //fixedRate 表示任务执行之间的时间间隔，具体是指两次任务的开始时间间隔，即第二次任务开始时，第一次任务可能还没结束。
    public void fixedRate() {
        System.out.println("fixedRate>>>"+new Date());
    }
    @Scheduled(fixedDelay = 2000)
    //fixedDelay 表示任务执行之间的时间间隔，具体是指本次任务结束到下次任务开始之间的时间间隔。
    public void fixedDelay() {
        System.out.println("fixedDelay>>>"+new Date());
    }
    @Scheduled(initialDelay = 2000,fixedDelay = 2000)
    //initialDelay 表示首次任务启动的延迟时间。
    public void initialDelay() {
        System.out.println("initialDelay>>>"+new Date());
    }
    @Scheduled(cron = "0/2 * * * * ?")
    //[秒] [分] [小时] [日] [月] [周]
    //0秒开始每2秒执行一次
    //可以在线搜索cron表达式生成器
    //https://cron.qqe2.com/
    public void cron(){
        System.out.println("cron>>>"+new Date());
    }
}
