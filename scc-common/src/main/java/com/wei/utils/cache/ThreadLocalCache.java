package com.wei.utils.cache;

public class ThreadLocalCache {
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前线程的缓存
     *
     * @return
     */
    public static Object get() {
        Object result = threadLocal.get();
        threadLocal.remove();
        return result;
    }

    /**
     * 设置当前线程的缓存
     */
    public static void set(Object object) {
        threadLocal.set(object);
    }
}
