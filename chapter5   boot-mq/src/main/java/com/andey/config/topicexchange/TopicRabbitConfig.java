package com.andey.config.topicexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created by jiangbin on 2018/12/7.
 * topicExchange是最灵活的一种方式，可以根据routing_key 自由绑定不同的队列
 */
@Configuration
public class TopicRabbitConfig {
    /**
     * 这里方便起见，队列名称和route_key的名称一致
     * 配置了队列topic.message1和topic.message2
     */
    final static String message1 = "topic.message1";
    final static String message2 = "topic.message2";


    //初始化两个队列
    @Bean
    public Queue queueMessage1(){
        return new Queue(TopicRabbitConfig.message1);
    }

    @Bean
    public Queue queueMessage2(){
        return new Queue(TopicRabbitConfig.message2);
    }

    //指定并初始化交换机 topicExchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    //给队列绑定 exchange 和 routing_key,这块理解有点逆思维，就好比路由，
    //重发送的信息了获取rout_key,批到到的都会发送出去。
    //如，的route_key是  topic.message1;
    //那么bindingExchangeMessage1 和 bindingExchangeMessage2都可以匹配这个route信息
    //所以队列message1和message1都能收到下次
    //反之如果获取的route_key是 topic.message2，能匹配的交换机只有bindingExchangeMessage2，
    //所以只有队列message2能收到消息
    @Bean
    public Binding bindingExchangeMessage1(Queue queueMessage1, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message1");
    }

    @Bean
    public Binding bindingExchangeMessage2(Queue queueMessage2, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }

}
