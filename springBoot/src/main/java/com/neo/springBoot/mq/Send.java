package com.neo.springBoot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 生产者
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月8日 下午5:35:00
 * @version 1.0
 */
public class Send {

	public static void main(String[] args) throws Exception{
		
		Connection connection = MyConnectionFactory.getConnectionFactory().newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(MyConnectionFactory.QUEUE_NAME, false, false, false, null);
		
		String messageString = "hello world";
		
		channel.basicPublish("", MyConnectionFactory.QUEUE_NAME, null, messageString.getBytes());
		
		System.out.println("Sent Message：'" + messageString + "'"); 
		 
		channel.close();
		connection.close();
		
	}
}
