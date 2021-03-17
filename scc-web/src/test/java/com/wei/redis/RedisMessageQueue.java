package com.wei.redis;

import com.wei.utils.cache.RedisUtils;
import com.wei.web.SmartConstrolCostApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = SmartConstrolCostApplication.class)
@RunWith(SpringRunner.class)
public class RedisMessageQueue {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * redis实现消息队列
     * 需要在com.wei.web.config.RedisConfig
     * 将RedisMessageListenerContainer和MessageListenerAdapter的注解打开 才能测试
     */
    @Test
    public void sendMessage(){
        redisUtils.convertAndSend("topic","1232141312");
    }

    /**
     * 批量添加数据
     */
    @Test
    public void puts(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "jack");
        map.put("age", 21);
        redisUtils.puts(map);
    }

    /**
     * 如果存在就删除
     */
    @Test
    public void delKeyIfExists(){
        redisUtils.delKeyIfExists("name","jack");
    }

    /**
     * 删除所有的键
     */
    @Test
    public void delKeys(){
        redisUtils.delKeys(new String[]{ "name","age"},new Object[]{"jack", 21});
    }
}
