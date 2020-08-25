# spring-boot
1、 chapter1  基本idea 快速构建一个spring boot web工程

2、chapter2  "boot2-config"自定义属性、将配置文件的属性赋值给实体bean、自定义配置文件及多环境配置文件的配置

3、chapter3  "boot2-scheduled" 定时任务、同步、并行处理、异步处理

4、chapter4  "boot2-swagger2" swagger2和swagger ui 不一样的自动生成接口API文档
加依赖 <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.7</version>
        </dependency>
 应用bootstrap-ui 优化swagger管理界面
 
 5、chapter5  "boot2-mq"  异步处理、解耦、秒杀流量消峰、数据持久化特点，采用topicExchange最灵活的模式（前提：本地安装MQserver服务，下载web管理界面插件）
 
 6、chapter6 "boot2-mq-ack" mq消息处理整合ack消息确认机制，手动ack（前提：本地安装MQserver服务，下载web管理界面插件）
 
 7、chapter7 "boot2-mybatis-mysql" 至于自动生成就算了，个人觉得更费劲，整合mybatis+mysql
 
 8、chapter8 "boot2-poi" springboot 整合poi 实现Excel读取和写入 ，一个List<>物理分页的一个小方法，挺好用
 
 9、chapter9 "boot2-cxf" springboot整合cxf 实现webservice服务发布及客户端的远程调用  忽略wsimport生成实体弊端 实现 代理模式及动态请求
 
 10、chapter10 "mybatis plus" 还是plus好用啊，好久没用了，怀念一下。
