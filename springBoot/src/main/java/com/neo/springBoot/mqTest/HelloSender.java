package com.neo.springBoot.mqTest;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月5日 下午6:20:38
 * @version 1.0
 */
public class HelloSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(){
		String context = "hello" + new Date();
		System.out.println("Sender: " + context);
		amqpTemplate.convertAndSend("hello", context);
	}

}
