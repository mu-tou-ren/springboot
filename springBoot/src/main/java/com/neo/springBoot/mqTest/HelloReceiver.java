package com.neo.springBoot.mqTest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月5日 下午6:52:31
 * @version 1.0
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {    
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}
