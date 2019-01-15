package com.andey.service.impl;

import com.andey.service.DemoService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by jiangbin on 2019/1/15.
 */
@WebService(name="DemoService",//与接口指定的name一致
                  targetNamespace = "http://andey.com",//与接口的命名空间一致，一般是接口的包名倒叙
                   endpointInterface = "com.andey.service.DemoService")
@Component
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String user) {
        return user+":hello"+"("+new Date()+")";
    }
}
