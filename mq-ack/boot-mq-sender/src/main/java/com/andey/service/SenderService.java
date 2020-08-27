package com.andey.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangbin on 2018/12/7.
 */

@Service
public class SenderService implements RabbitTemplate.ReturnCallback  {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send1(){
        String context = "hi, i am message WaHaHa!";
        this.rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {

                    if (!ack) {
                        System.out.println("Sender 发送消息失败" + cause + correlationData.toString());
                    } else {
                        System.out.println("Sender 消息发送成功 ");
                    }
        });
        rabbitTemplate.convertAndSend("fanoutExChange", null, context);
    }


    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
    System.out.println("开始打印：==message"+message+"==replyCode"+replyCode+"==replyText"+replyText+"routingKye"+routingKey);
    }
}
