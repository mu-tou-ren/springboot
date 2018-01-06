package com.neo.springBoot.mqTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 *
 * @author Li Zhenbang
 * @date 创建时间：2018年1月5日 下午6:55:51
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {    
    @Autowired
    private HelloSender helloSender;    
   
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

}
