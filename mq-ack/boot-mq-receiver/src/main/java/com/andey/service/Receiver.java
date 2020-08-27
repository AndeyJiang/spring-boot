package com.andey.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jiangbin on 2018/12/7.
 */
@Component
@EnableRabbit
public class Receiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue1"),
            exchange = @Exchange(value = "fanoutExChange",type = ExchangeTypes.FANOUT)
    ))
    @RabbitHandler
    public void process2(String helloService, Channel channel, Message message) throws  Exception {

        try {
            //确认消息 false ，true  没有查看除区别
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("Receiver myQueue1:" + helloService);
        } catch (IOException e) {
            e.printStackTrace();
            //消息拒绝  true 拒绝，循环播放    false  拒绝并从mq中产出
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("receiver fail");

        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue2"),
            exchange = @Exchange(value = "fanoutExChange",type = ExchangeTypes.FANOUT)
    ))
    @RabbitHandler
    public void process(String helloService, Channel channel, Message message) throws  Exception {
        try {
            //确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("Receiver myQueue2 :" + helloService);
        } catch (IOException e) {
            e.printStackTrace();
            //消息拒绝
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("receiver fail");

        }
    }

}

