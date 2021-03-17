package com.wei.code.pattern.strategy;


import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// 使用工厂模式 + 策略模式
public class StrategyPattern {
    @Data
    public class Order {
        //id
        private int id;
        //类型
        private String type;
        //价格
        private BigDecimal price;
        //商品名称
        private String name;
    }

    /**
     * 订单处理接口
     */
    public interface IOrderService {
        void handle(Order order);
    }

    /**
     * 普通订单实现类
     */
    public class GeneralOrderService implements IOrderService {
        @Override
        public void handle(Order order) {
            System.out.println("普通订单...");
        }
    }

    /**
     * 团购订单实现类
     */
    public class GroupBuyingOrderService implements IOrderService {
        @Override
        public void handle(Order order) {
            System.out.println("团购订单...");
        }
    }

    public class OrderServiceFactory{
        private  Map<String, Object> map;

        private OrderServiceFactory(){
            map = new HashMap<>();
            map.put("general",new GeneralOrderService());
            map.put("groupBuying",new GroupBuyingOrderService());
        }

        public  IOrderService getOrderService(String type){
            return (IOrderService)map.get(type);
        }

    }

    /**
     * 策略模式测试方法
     */
    @Test
    public void strategyPatternTest(){
        Order order = new Order();
        order.setId(1);
        order.setName("普通订单");
        order.setPrice(new BigDecimal(123));
        order.setType("general");
        //如果是一般的方式
        System.out.println("使用一般的方式...");
        if("general".equals(order.getType())){
            new GeneralOrderService().handle(order);
        } else if("groupBuying".equals(order.getType())){
            new GroupBuyingOrderService().handle(order);
        }
        //如果使用策略模式的方式
        //因为内部类不能创建static方法 所以工厂暂时使用new替代
        System.out.println("使用策略模式...");
        IOrderService orderService = new OrderServiceFactory().getOrderService(order.getType());
        orderService.handle(order);
    }

}
