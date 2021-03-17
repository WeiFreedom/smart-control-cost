package com.wei.code.pattern.observer;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 * Java自带的观察订阅者模式
 */
public class JavaObserverPattern {
    /**
     * 自定义观察者模式测试
     */
    @Test
    public void customObserverTest(){
        CustomSubject observable = new CustomSubject();

        Observer observer1 = new CustomObserver1();
        Observer observer2 = new CustomObserver2();


        observable.addObserver(observer2);
        observable.addObserver(observer1);

        observable.invoke("传入的参数");
    }

    /**
     * 观察者
     */
    public class CustomSubject extends Observable{

        public void  invoke(String args){
            setChanged();
            notifyObservers(args);
        }

    }

    /**
     * 订阅者1
     */
    public  class CustomObserver1 implements Observer{
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("调用了CustomObserver1:" + arg);
        }
    }

    /**
     * 订阅者2
     */
    public  class CustomObserver2 implements Observer{
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("调用了CustomObserver2:" + arg);
        }
    }

}
