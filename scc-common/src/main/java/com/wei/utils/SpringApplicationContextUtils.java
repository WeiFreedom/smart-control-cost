package com.wei.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContextUtils  implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public static <T> T getBean(String beanName){
        AssertUtils.notNull(applicationContext,"%s","ApplicationContext对象注入失败!");
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<?> clazz){
        AssertUtils.notNull(applicationContext,"%s","ApplicationContext对象注入失败!");
        return (T) applicationContext.getBean(clazz);
    }
}
