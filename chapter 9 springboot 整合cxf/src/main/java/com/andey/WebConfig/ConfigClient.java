package com.andey.WebConfig;

import com.andey.User;
import com.andey.service.DemoService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2019/1/15.
 */
@Component
public class ConfigClient {

    public  String  cl1() {
        String result="";
        try {
            // 接口地址
            String address = "http://localhost:8088/services/DemoService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(DemoService.class);
            // 创建一个代理接口实现
            DemoService cs = (DemoService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userName = "LemmonTree";
            // 调用代理接口的方法调用并返回结果
            result = cs.sayHello(userName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    public static void cl2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8089/services/CommonService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayHello", "LemmonTree");

            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }


}
