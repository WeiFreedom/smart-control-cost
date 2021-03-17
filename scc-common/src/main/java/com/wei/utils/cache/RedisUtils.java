package com.wei.utils.cache;

import com.wei.utils.AssertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtils {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private GenericToStringSerializer genericToStringSerializer;

    private static final Long SUCCESS = 1L;
    private static final String IP = "ip";
    private static final String OK = "OK";

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

    //============================String=============================
    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key,Object value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else{
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 递增
     * @param key 键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta){
        if(delta<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key 键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta){
        if(delta<0){
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    //================================Map=================================
    /**
     * HashGet
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key,String item){
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object,Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String,Object> map){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     * @param key 键
     * @param map 对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String,Object> map, long time){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if(time>0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value,long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if(time>0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除hash表中的值
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item){
        redisTemplate.opsForHash().delete(key,item);
    }

    /**
     * 判断hash表中是否有该项的值
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item){
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     * @param key 键
     * @param item 项
     * @param by 要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item,double by){
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     * @param key 键
     * @param item 项
     * @param by 要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item,double by){
        return redisTemplate.opsForHash().increment(key, item,-by);
    }

    //============================set=============================
    /**
     * 根据key获取Set中的所有值
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     * @param key 键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key,Object value){
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     * @param key 键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object...values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     * @param key 键
     * @param time 时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key,long time,Object...values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if(time>0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 移除值为value的
     * @param key 键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object ...values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }
    //===============================list=================================

    /**
     * 获取list缓存的内容
     * @param key 键
     * @param start 开始
     * @param end 结束  0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     * @param key 键
     * @return
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     * @param key 键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key,long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     * @param key 键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index,Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 移除N个值为value
     * @param key 键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key,long count,Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 模糊查询获取key值
     * @param pattern
     * @return
     */
    public Set keys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * 使用Redis的消息队列
     * @param channel
     * @param message 消息内容
     */
    public void convertAndSend(String channel, Object message){
        redisTemplate.convertAndSend(channel,message);
    }


    //=========BoundListOperations 用法 start============

    /**
     *将数据添加到Redis的list中（从右边添加）
     * @param listKey
     * @param expireValue 过期时间
     * @param timeUnit 过期时间单位
     * @param values 待添加的数据
     */
    public void addToListRight(String listKey,long expireValue, TimeUnit timeUnit, Object... values) {
        //绑定操作
        BoundListOperations<String, Object> boundValueOperations = redisTemplate.boundListOps(listKey);
        //插入数据
        boundValueOperations.rightPushAll(values);
        //设置过期时间
        boundValueOperations.expire(expireValue,timeUnit);
    }
    /**
     * 根据起始结束序号遍历Redis中的list
     * @param listKey
     * @param start  起始序号
     * @param end  结束序号
     * @return
     */
    public List<Object> rangeList(String listKey, long start, long end) {
        //绑定操作
        BoundListOperations<String, Object> boundValueOperations = redisTemplate.boundListOps(listKey);
        //查询数据
        return boundValueOperations.range(start, end);
    }
    /**
     * 弹出右边的值 --- 并且移除这个值
     * @param listKey
     */
    public Object rifhtPop(String listKey){
        //绑定操作
        BoundListOperations<String, Object> boundValueOperations = redisTemplate.boundListOps(listKey);
        return boundValueOperations.rightPop();
    }

    //=========BoundListOperations 用法 End============

    //=========redis 分布式事务锁============
    /**
     * 加锁
     * 这种方式加锁会有一定的问题
     * 1. 在redis的master节点上拿到了锁
     * 2. 但是这个key没有同步到slave节点
     * 3. master节点故障 发生故障转移 slave节点升级成master节点
     * 4. 锁丢失
     * 正因为可能出现这种情况 redis作者提出了一种更高级的分布式锁实现方案 Redlock
     * @param lockKey key
     * @param value 通过赋值value就知道是哪个请求加的锁
     * @param expireTime 过期时间 s 秒
     * @return
     */
    public boolean tryLock(String lockKey, String value, int expireTime) {
        // 1.实现一
        String script = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then redis.call('expire', KEYS[1], ARGV[2]) return 1 else return 0 end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript, genericToStringSerializer,genericToStringSerializer,
                Collections.singletonList(lockKey),
                value, expireTime);
        if (SUCCESS.equals(result)) {
            return true;
        }
        return false;
        // 2.实现二
        // return redisTemplate.opsForValue().setIfAbsent(lockKey, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 一直等待加锁
     * @param lockKey key
     * @param value 通过赋值value就知道是哪个请求加的锁
     * @param expireTime 锁的过期时间
     * @return
     */
    public  boolean waitLock(String lockKey, String value, int expireTime){
        boolean loop = true;
        int waitTime = expireTime;
        while (loop){
            loop=!tryLock(lockKey,value,expireTime);
            if(waitTime<=0){
                return false;
            }
            if(loop) {
                try {
                    Thread.sleep(1000);
                    waitTime -= 1;
                } catch (InterruptedException ex) {
                    log.error(ex.getMessage(),ex);
                    return false;
                }
            }
        }
        return !loop;
    }

    /**
     * 解锁
     * @param key key
     * @param value 通过value解锁
     * @return
     */
    public boolean unLock(String key, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(key), value);
        if (SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
    //=========redis执行lua脚本 保证原子性============

    /**
     * m秒内192.168.1.1访问是否超过了n次
     * @param ipAddress ip地址
     * @param visitNumber 访问次数
     * @param expireTime 多少时间内
     * @return
     */
    public boolean repeatVisit(String ipAddress, int visitNumber,int expireTime){
        String script  = "local cnt = redis.call('INCR',KEYS[1]) if cnt > tonumber(ARGV[1]) then   return 1 end if cnt == 1 then   redis.call('EXPIRE', KEYS[1], ARGV[2]) end return 0";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(IP+ipAddress), visitNumber, expireTime);
        if (SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 根据pattern批量删除所有的key
     * 不能在生产环境使用以下命令,会导致redis阻塞
     * eval "redis.call('del', unpack(redis.call('keys', 'prefix:*')))" 0
     * @param pattern 例如 name*
     * @return
     */
    public  boolean delAllByPattern(String pattern){
        String script = "local cursor = '0' local count = 0 repeat local result = redis.call('SCAN', cursor, 'MATCH', KEYS[1], 'COUNT', 500) cursor = result[1] count = count + #result[2] until cursor == '0' return count";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(pattern));
        if (result!=null && (Long)result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 初始化一个布隆过滤器
     * Redis安装bloomfilter
     * 1. cd /usr/local/redis
     * 2.mkdir module && cd module
     * 3.yum -y install git
     * 4.git clone https://github.com/RedisLabsModules/redisbloom.git
     * 5. cd redisbloom/
     * 6.make
     * 7.得到动态库 redisbloom.so
     * 8. 在redis.conf增加如下配置 loadmodule ../module/redisbloom/redisbloom.so
     * 9. pkill redis
     * 10. /usr/local/redis/bin/redis-server /usr/local/redis/etc/redis.conf
     * @param key 布隆过滤器的key
     * @param errorRate 错误率
     * @param count 初始大小
     * @return
     */
    public boolean initBloomFilter(String key,Long errorRate,Integer count){
        String script = "redis.call('bf.reserve', KEYS[1], ARGV[1], ARGV[2])";
        RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(key),errorRate,count);
        if(result!=null && OK.equals(result.toString())){
            return true;
        }
        return false;
    }

    /**
     * 往布隆过滤器添加数据
     * @param key
     * @param value
     * @return
     */
    public boolean addBloomFilter(String key,String value){
        String script = "redis.call('bf.add', KEYS[1], ARGV[1])";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(key),value);
        if(SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 是否存在布隆过滤器中
     * @param key
     * @param value
     * @return
     */
    public boolean existBloomFilter(String key,String value){
        String script = "redis.call('bf.exists', KEYS[1], ARGV[1])";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(key),value);
        if(SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 批量删除key的值等于传入的值的数据
     * @param keys 所有的key
     * @param values key对应的值
     * @return
     */
    public boolean delKeys(String[] keys,Object[] values){
        String script = "local len=#KEYS for i=1,len do if redis.call('get',KEYS[i]) == ARGV[i] then  redis.call('del',KEYS[i]) end end  return true";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        List<String> keysList = Arrays.asList(keys);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, keysList,values);
        if(SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 如果存在key==value则删除 否则返回失败
     * @param key
     * @param value
     * @return
     */
    public boolean delKeyIfExists(String key,String value){
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then  redis.call('del',KEYS[1]) return true else return false end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, Collections.singletonList(key),value);
        if(SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 批量增加数据
     * @param map
     * @return
     */
    public boolean puts(Map<String,Object> map){
        AssertUtils.notNull(map,"redis values is null!");
        String[] keys = new String[map.size()];
        Object[] values = new Object[map.size()];
        int index = 0;
        for(Map.Entry<String,Object> m : map.entrySet()){
            keys[index] = m.getKey();
            values[index] = m.getValue();
            index++;
        }

        String script = "local keys,values=KEYS,ARGV for i,v in ipairs(keys) do redis.call('SET',keys[i],values[i]) end  return true";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        List<String> keysList = Arrays.asList(keys);
        Object result = redisTemplate.execute(redisScript,genericToStringSerializer,genericToStringSerializer, keysList,values);
        if(SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
}
