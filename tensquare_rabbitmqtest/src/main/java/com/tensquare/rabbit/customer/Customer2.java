package com.tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author huachen
 * @create 2019-01-17 9:15
 */

@Component
@RabbitListener(queues = "hc2")
public class Customer2 {

    @RabbitHandler
    public void getMsg(String message) {
        System.out.println("hc2接收到消息: " + message);
    }
}
