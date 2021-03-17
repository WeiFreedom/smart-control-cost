package com.wei.code;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

public class JavaThread {

    @Test
    public void testThread() throws InterruptedException {

        /**
         * 1 继承Thread
         */
//        Thread thread1 = new CalcThread();
//        thread1.start();

        /**
         * 2 继承Runnable
         * 相对于继承Thread 改变了单继承的缺点
         */
//        Thread thread2 = new Thread(new CalcRunnable());
//        thread2.start();

        /**
         * 3 继承Callable
         * 指定一个单线程池Executors.newSingleThreadExecutor()
         * 自始至终都是一个线程
         * 相对于Thread,Runnable带有返回值
         */
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        Future<Object> future = threadPool.submit(new CalcCallable());
//        try {
//            System.out.println("Callable==========" + future.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /**
         * 4 线程池
         * 4.1) Executors.newSingleThreadExecutor() 单线程池 自始至终都是一个线程
         * 4.2) Executors.newCachedThreadPool() 如果线程池的数量很大 那么会回收无用的线程 如果线程数不足 会创建线程
         * 这种方式虽然可以根据业务场景自动的扩展线程数来处理我们的业务，但是最多需要多少个线程同时处理缺是我们无法控制的；
         * 优点是能实现线程的复用 比如线程1结束了 下一个任务来了 线程1能继续工作
         * 4.3) Executors.newFixedThreadPool() 可以指定线程池中的线程数
         * 4.4) Executors.newScheduledThreadPool() 支持定时，以及周期性的任务执行
         */
        // 4.1) 示例
//        ExecutorService executor1 = Executors.newSingleThreadExecutor();
//        for(int index=0;index<=9;index++){
//            final int count = index;
//            executor1.execute(() -> {
//                System.out.println("newSingleThreadExecutor单线程池======="+count);
//            });
//        }
        // 4.2) 示例
//        ExecutorService executor2 = Executors.newCachedThreadPool();
//        for(int index=0;index<=9;index++){
//            final int count = index;
//            executor2.execute(() -> {
//                System.out.println("newCachedThreadPool线程池,当前线程name"+Thread.currentThread().getName()+"======="+count);
//            });
//        }
        // 4.3) 示例
//        ExecutorService executor3 = Executors.newFixedThreadPool(3);
//
//        for(int index=0;index<=9;index++){
//            final int count = index;
//            executor3.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("newFixedThreadPool线程池,当前线程name"+Thread.currentThread().getName()+"======="+count);
//                }
//            });
//        }


        // 4.4)  示例 initalDelay 延迟第一次执行的时间 period 连续执行之间的时间间隔
//        ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(3);
//
//        executor4.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                // 定时任务有一个问题就是 如果执行时间>间隔时间 那么任务执行间隔会错乱
////                Date start = new Date();
////                try {
////                    Thread.sleep(6);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                Date end = new Date();
////                System.out.println("花费时间:"+ (end.getTime()-start.getTime())/1000);
////                System.out.println("结束时间:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(end));
////
//                System.out.println("newScheduledThreadPool线程池,当前线程name" + Thread.currentThread().getName());
//            }
//        }, 1, 5, TimeUnit.SECONDS);
//        Thread.sleep(50000);


        /**
         * 5. 等待线程池的任务执行完毕再继续
         */

//        ExecutorService executor5 = Executors.newFixedThreadPool(3);
//        for(int index=0;index<=9;index++) {
//            final int count = index;
//            //5.1. 提交线程任务
//            executor5.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("newFixedThreadPool线程池,当前线程name" + Thread.currentThread().getName() + "=======" + count);
//                }
//            });
//        }
//        //5.2. 不在接收新的任务
//        executor5.shutdown();
//        //5.3. 等待所有线程执行完毕
//        executor5.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
//        System.out.println("所有的线程都执行完毕了!");

        /**
         * 6. 自定义线程的任务执行完毕再继续
         */
//        int count = 5;
//        Thread[] threads = new Thread[count];
//        final CountDownLatch latch = new CountDownLatch(count);
//        for (int index = 0; index < count; index++) {
//            final int threadIndex = index;
//            threads[index] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("自定义线程,当前线程name" + Thread.currentThread().getName() + "=======" + threadIndex);
//                    latch.countDown();
//                }
//            });
//            threads[index].start();
//        }
//        latch.await();
//        System.out.println("所有的线程都执行完毕了!");

    }


    public class CalcCallable implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            return Thread.currentThread().getName();
        }
    }

    public class CalcRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable==========" + Thread.currentThread().getName());
        }
    }

    public class CalcThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread==========" + Thread.currentThread().getName());
        }
    }
}


