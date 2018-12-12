package com.andey.config.topicexchange;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jiangbin on 2018/12/7.
 */
@Component
@RabbitListener(queues = "topic.message2")
public class TopicReceiver1 {
    @RabbitHandler
    public void process(String helloreceive, Channel channel, Message message) throws  Exception {

        System.out.println("Receiver topic.message1 :" + helloreceive);
        try {
              //确认消息
              System.out.println(message.getMessageProperties().getDeliveryTag());
              channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
              System.out.println("receiver success");
        } catch (IOException e) {
            e.printStackTrace();
            //消息拒绝
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("receiver fail");

        }
    }
}
