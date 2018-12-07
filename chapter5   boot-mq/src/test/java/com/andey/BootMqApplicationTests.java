package com.andey;

import com.andey.config.topicexchange.TopicRabbitSenderConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMqApplicationTests {
    @Autowired
	TopicRabbitSenderConfig topicRabbitSenderConfig;

	@Test
	public void contextLoads() {
		topicRabbitSenderConfig.send1();
	}
	@Test
	public void contextLoad1() {
		topicRabbitSenderConfig.send2();
	}

}
