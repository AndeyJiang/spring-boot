package com.andey.config.topicexchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2018/12/7.
 */
@Component
@RabbitListener(queues = "topic.message2")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver topic.message2: "+ message);

    }
}
