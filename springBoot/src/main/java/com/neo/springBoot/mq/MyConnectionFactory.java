package com.neo.springBoot.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月8日 下午5:55:36
 * @version 1.0
 */
public class MyConnectionFactory {

	public final static String QUEUE_NAME = "helloworld";
	
	public final static String QUEUE_NAME2 = "wordqueue-durable";
	
	public static ConnectionFactory getConnectionFactory() throws Exception{
	
		ConnectionFactory factory= new ConnectionFactory();
		
		factory.setHost("172.16.19.205");
		factory.setUsername("admin");
		factory.setPassword("123456");
		factory.setPort(AMQP.PROTOCOL.PORT);
		return factory;
	}
}
