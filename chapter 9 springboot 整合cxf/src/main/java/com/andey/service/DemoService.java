package com.andey.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by jiangbin on 2019/1/15.
 */
@WebService(name="DemoService",//暴露服务名称
                             targetNamespace = "http://andey.com"//命名空间，一般是接口的包名倒叙
)
public interface DemoService {
     @WebMethod
     @WebResult(name="String")
    String sayHello(String user);
}
