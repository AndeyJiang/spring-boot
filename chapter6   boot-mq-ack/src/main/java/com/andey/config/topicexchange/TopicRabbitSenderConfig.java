package com.andey.config.topicexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by jiangbin on 2018/12/7.
 */

@Service
public class TopicRabbitSenderConfig implements RabbitTemplate.ReturnCallback {
    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send1(){
        String context = "hi, i am message";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
                    if (!ack) {
                        System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
                    } else {
                        System.out.println("HelloSender 消息发送成功 ");
                    }
        });
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message2", context);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s);
    }
}
