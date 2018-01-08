package com.neo.springBoot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 消费者
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月8日 下午5:53:38
 * @version 1.0
 */
public class Receive {

	public static void main(String[] args) throws Exception{
		
		Connection connection = MyConnectionFactory.getConnectionFactory().newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(MyConnectionFactory.QUEUE_NAME, false, false, false, null);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		
		channel.basicConsume(MyConnectionFactory.QUEUE_NAME, true, consumer);
		
		 while (true){    
            //nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）    
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();    
            String message = new String(delivery.getBody());    
            System.out.println("Received Message：'" + message + "'");    
        }  
	}
}
