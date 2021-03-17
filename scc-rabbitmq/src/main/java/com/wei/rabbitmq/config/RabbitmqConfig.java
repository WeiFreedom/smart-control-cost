package com.wei.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(prefix = "spring.rabbitmq", value = "enabled", havingValue = "true")
public class RabbitmqConfig {

    @Bean
    public Queue mailQueue() {
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl", 60*1000*60);//设置过期时间1h
        args.put("x-expires", 60*1000*60);//设置队列的过期时间,闲置1h后过期
        args.put("x-queue-mode", "lazy");
        return new Queue("mail",false, false, false,args);
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("mailTopicExchange");
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(mailQueue()).to(exchange()).with("mail");
    }
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果如何都会调用回调函数
        rabbitTemplate.setMandatory(true);
        //消息推送到了server 但是server找不到交换机
        //消息推送到了server 找到交换机 但是没有找到队列
        //消息推送到sever，交换机和队列啥都没找到
        //消息推送成功
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("ConfirmCallback:    相关数据"+ correlationData);
                System.out.println("ConfirmCallback:    确定情况"+ b);
                System.out.println("ConfirmCallback:    原因"+ s);
            }
        });
        //消息推送到了server 找到交换机 但是没有找到队列
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("ReturnsCallback:    相关返回信息"+ returnedMessage);
            }
        });

        return rabbitTemplate;
    }
}
