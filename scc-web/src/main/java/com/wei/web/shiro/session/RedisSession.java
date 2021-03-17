package com.wei.web.shiro.session;

import com.wei.utils.cache.RedisUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class RedisSession extends EnterpriseCacheSessionDAO {
    public static final String prefix = "shrio_redis:";
    @Autowired
    @Qualifier("shiroRedisTemplate")
    private RedisTemplate<String, Object> shiroRedisTemplate;
    @Override
    protected Serializable doCreate(Session session) { // 创建Session，返回session id
        Serializable sessionId = super.doCreate(session); // 创建sessionid
        // 将当前创建好的Session的数据保存在Redis数据库里面
        shiroRedisTemplate.opsForValue().set(prefix+sessionId.toString(), session, 6000, TimeUnit.SECONDS);
        return sessionId;
    }
    @Override
    protected Session doReadSession(Serializable sessionId) { // 根据session
        if(sessionId==null){
            return null;
        }
        Session session = (Session) shiroRedisTemplate.opsForValue().get(prefix+sessionId.toString());// id读取session数据
        return session;
    }
    @Override
    protected void doUpdate(Session session) { // 实现Session更新，每次操作都要更新
        super.doUpdate(session);
        if (session != null) {
            shiroRedisTemplate.opsForValue().set(prefix+session.getId().toString(),session, 1800, TimeUnit.SECONDS);
        }
    }
    @Override
    protected void doDelete(Session session) { // session的删除处理
        super.doDelete(session);
        if(session!=null) {
            shiroRedisTemplate.delete(Arrays.asList(prefix + session.getId().toString()));
        }
    }
}
