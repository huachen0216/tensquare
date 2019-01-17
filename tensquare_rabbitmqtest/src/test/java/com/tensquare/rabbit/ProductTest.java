package com.tensquare.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huachen
 * @create 2019-01-17 9:08
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApp.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend("hc1", "仅仅只是一个测试！！");
    }

    @Test
    public void testExchangeSend() {
        rabbitTemplate.convertAndSend("hcexchange", "", "分裂模式");
    }

    @Test
    public void testTopicSend() {
        rabbitTemplate.convertAndSend("topic", "good.abc.log", "主题模式");
    }
}
