package com.neo.springBoot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

/**
 *
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月8日 下午6:15:06
 * @version 1.0
 */
public class Task {
	
	public static void main(String[] args) throws Exception{
		
		Connection connection = MyConnectionFactory.getConnectionFactory().newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(MyConnectionFactory.QUEUE_NAME2, true, false, false, null);
		
		for (int i = 5; i > 0; i--)    
        {    
            String dots = "";    
            for (int j = 0; j <= i; j++)    
            {    
                dots += ".";    
            }    
            String message = "helloworld" + dots+dots.length();    
            //MessageProperties.PERSISTENT_TEXT_PLAIN 标识我们的信息为持久化的  
            channel.basicPublish("", MyConnectionFactory.QUEUE_NAME2, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());    
            System.out.println("Sent Message：'" + message + "'");    
        }    
        //关闭频道和资源    
        channel.close();    
        connection.close();  
		
		
	}

}
