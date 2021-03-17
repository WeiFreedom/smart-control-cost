package com.wei.web;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//SpringBoot启动类
@SpringBootApplication
//mapper接口扫描
@MapperScan(basePackages = "com.wei.dao")
//开启事务支持
@EnableTransactionManagement
//注解扫描
@ComponentScan(basePackages = "com.wei.**")
//允许定时任务
@EnableScheduling
public class SmartConstrolCostApplication {
    private static final Logger logger = LoggerFactory.getLogger(SmartConstrolCostApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SmartConstrolCostApplication.class, args);
        logger.info("程序启动成功!");
    }



}
