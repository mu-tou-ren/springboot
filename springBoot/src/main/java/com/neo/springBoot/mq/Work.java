package com.neo.springBoot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 *
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月8日 下午6:29:34
 * @version 1.0
 */
public class Work {
	
	public static void main(String[] args) throws Exception{
		int hashCode = Work.class.hashCode();
		
		Connection connection = MyConnectionFactory.getConnectionFactory().newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(MyConnectionFactory.QUEUE_NAME2, true, false, false, null);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		
		channel.basicConsume(MyConnectionFactory.QUEUE_NAME2, false, consumer);
		
		//公平转发  设置最大服务转发消息数量    只有在消费者空闲的时候会发送下一条信息。  
        int prefetchCount = 1;  
        channel.basicQos(prefetchCount);  
        
        while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			
			String message = new String(delivery.getBody()).intern();
			
			doWork(message);
			
			System.out.println(hashCode + " Received Done"); 
			
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			
		}
	}
	
	/**  
     * 每个点耗时1s  
     * @param task  
     * @throws InterruptedException  
     */    
    private static void doWork(String task) throws InterruptedException {    
    	
        for (char ch : task.toCharArray())    
        {    
            if (ch == '.')    
                Thread.sleep(1000);    
        }    
    }    

}
