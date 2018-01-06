package com.neo.springBoot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置队列
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月5日 下午5:47:28
 * @version 1.0
 */
@Configuration
public class RabbitConfig {

	@Bean
    public Queue Queue() {        
        return new Queue("hello");
    }
}
