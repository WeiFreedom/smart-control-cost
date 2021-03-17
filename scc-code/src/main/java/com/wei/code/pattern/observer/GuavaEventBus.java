package com.wei.code.pattern.observer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;



public class GuavaEventBus {
    /**
     * 事件总线的实例对象
     */
    private static volatile EventBus instance;
    /**
     * 获取事件总线的实例
     * EventBus一共提供了4种线程模型ThreadModel，分别是PostThread, MainThread, BackgroundThread, Async。
     * PostThread --------------默认实现，执行发生在发布事件的同一个线程；
     * MainThread --------------执行在UI主线程上；
     * BackgroundThread、Async---两个都是通过Executors.newCachedThreadPool()线程池来执行的。
     * @return
     */
    public static EventBus getInstance(){
        if (instance == null){
            synchronized (GuavaEventBus.class){
                if(instance == null){
                    instance = new EventBus();
                }
            }
        }
        return instance;
    }

    // Class is typically registered by the container.
    class EventBusChangeRecorder {
        //订阅事件,并且可以传递对象
        @Subscribe
        public void recordCustomerChange(EventContent args) {
            System.out.println("recordCustomerChange:" + args);
            args.setIdx(args.getIdx()+1);
        }
    }

    @Data
    @ToString
    class EventContent{
        private int idx;
        private String content;
    }

    @Test
    public void guavaEventBusTest(){
        //注册订阅者
        EventBusChangeRecorder eventBusChangeRecorder1 = new EventBusChangeRecorder();
        EventBusChangeRecorder eventBusChangeRecorder2 = new EventBusChangeRecorder();
        getInstance().register(eventBusChangeRecorder1);
        getInstance().register(eventBusChangeRecorder2);
        //注销事件
        //getInstance().unregister(eventBusChangeRecorder);
        EventContent content =  new EventContent();
        content.setIdx(1);
        content.setContent("内容");
        //发布事件
        getInstance().post(content);
    }

}
