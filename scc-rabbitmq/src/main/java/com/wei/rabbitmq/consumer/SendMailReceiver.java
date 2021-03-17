package com.wei.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = "mail")
@ConditionalOnProperty(prefix = "spring.rabbitmq", value = "enabled", havingValue = "true")
@Slf4j
public class SendMailReceiver {

    @RabbitHandler
    public void process(Map map, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("发送邮件  : " + map.toString());
            //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
            channel.basicAck(deliveryTag,false);
        } catch (Exception e){
            try {
                //第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
                channel.basicReject(deliveryTag, false);
            } catch (IOException ex) {
                log.error("消息回退失败!",ex);
            }
            log.error("消息确认失败!",e);
        }

    }
}
