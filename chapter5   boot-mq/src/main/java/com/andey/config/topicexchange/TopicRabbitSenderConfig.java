package com.andey.config.topicexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2018/12/7.
 */
@Configuration
public class TopicRabbitSenderConfig {
    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 根据绑定的exchange，sende1（）同事发送两个队列
     */
    public void send1(){
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        amqpTemplate.convertAndSend("topicExchange","topic.message1",context);
    }

    /**
     * 根据绑定的exchange，sende2（）发送一个队列mesage2
     */
    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.message2", context);
    }

}
