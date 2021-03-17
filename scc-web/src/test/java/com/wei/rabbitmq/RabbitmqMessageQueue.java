package com.wei.rabbitmq;

import com.wei.web.SmartConstrolCostApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest(classes = SmartConstrolCostApplication.class)
@RunWith(SpringRunner.class)
public class RabbitmqMessageQueue {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        Map<String,Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", "rabbitmq message");
        rabbitTemplate.convertAndSend("mailTopicExchange","mail",map);
    }

}
