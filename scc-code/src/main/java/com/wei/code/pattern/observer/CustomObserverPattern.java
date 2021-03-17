package com.wei.code.pattern.observer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomObserverPattern {

    /**
     * 自定义观察者模式测试
     */
    @Test
    public void customObserverTest(){
        Subject subject = new CustomSubject();

        Observer observer1 = new CustomObserver1();
        Observer observer2 = new CustomObserver2();

        subject.attach(observer1);
        subject.attach(observer2);

       //当事件改变的时候 通知到其他的订阅者
        subject.notifyChanged();
    }

    /**
     * 观察者订阅人对象
     */
    public interface Observer {

        /**
         * 接收变动通知
         */
        void update();
    }

    /**
     * 观察者主题对象
     */
    public interface Subject {

        /**
         * 订阅操作
         */
        void attach(Observer observer);

        /**
         * 取消订阅操作
         */
        void detach(Observer observer);

        /**
         * 通知变动
         */
        void notifyChanged();
    }

    /**
     * 自定义的观察者对象
     */
    public class  CustomSubject implements Subject{
        private List<Observer> observers;
        public CustomSubject(){
            synchronized (CustomSubject.class) {
                if(observers==null) {
                    observers = new ArrayList<>();
                }
            }
        }
        @Override
        public void attach(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyChanged() {
            for(Observer observer: observers){
                observer.update();
            }
        }
    }

    /**
     * 订阅1
     */
    public class CustomObserver1 implements Observer{
        public void update(){
            System.out.println("CustomObserver1的通知");
        }
    }

    /**
     * 订阅2
     */
    public class CustomObserver2 implements Observer{
        public void update(){
            System.out.println("CustomObserver2的通知");
        }
    }


}
