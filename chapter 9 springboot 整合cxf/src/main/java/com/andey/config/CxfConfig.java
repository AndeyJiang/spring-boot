package com.andey.config;

import com.andey.service.DemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by jiangbin on 2019/1/15.
 */
@Configuration
public class CxfConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Autowired
    DemoService demoService;

    /** JAX-WS **/
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint=new EndpointImpl(springBus(),demoService);
        endpoint.publish("/DemoService");
        return null;
    }
}
