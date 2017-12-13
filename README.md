# demo-rabbitmq
rabbitmq简单示例
windows版本: 
1.安装erl 下载地址：http://www.erlang.org/downloads 
2.安装RabbitMq 下载地址：http://www.rabbitmq.com/ 
3.安装RabbitMq Plugin 
rabbitmq-plugins enable rabbitmq_management 
信息: 用提供的模式无法找到文件。 
系统找不到指定的路径。 

****************************** 
ERLANG_HOME not set correctly. 
****************************** 

Please either set ERLANG_HOME to point to your Erlang installation or place the 
RabbitMQ server distribution in the Erlang lib folder. 
4.将ERLANG_HOME设置到rabbitmq-env.bat中 
5.rabbitmq-plugins enable rabbitmq_management执行 
Plugin configuration unchanged. 
        Applying plugin configuration to rabbit@XXXXX-PC... failed. 
* Could not contact node rabbit@XXXXX-PC. 
   Changes will take effect at broker restart. 
* Options: --online  - fail if broker cannot be contacted. 
            --offline - do not try to contact broker. 
6.将windows中的.erlang.cookies复制到用户目录下 
7.rabbitmq-plugins enable rabbitmq_management执行 
   Plugin configuration unchanged. 
   Applying plugin configuration to rabbit@XXXXX-PC... nothing to do. 
网上资料说这个样子成功 
8.8.创建人：rabbitmqctl  add_user  admin  123456  
9.设置权限： 
rabbitmqctl set_user_tags admin administrator  
rabbitmqctl set_permissions -p "/" admin ".*" ".*" ".*"  
10.rabbitmq-server.bat 
RabbitMQ 3.6.14. Copyright (C) 2007-2017 Pivotal Software, Inc. 
   ##  ##      Licensed under the MPL.  See http://www.rabbitmq.com/                                                                                                                                         
   ##  ## 
   ######  ##        C:/Users/AXXXX/AppData/Roaming/RabbitMQ/log/RABBIT~3.LOG 
   ########## 
11.经查看日志 Rabbit 服务启动成功. 
12.浏览器打开：http://localhost:15672/ 使用admin 123456 登录 
13.代码级别: 
   pom.xml 添加: 
   <dependency> 
        <groupId>org.springframework.cloud</groupId> 
        <artifactId>spring-cloud-starter-bus-amqp</artifactId> 
        <version>1.3.1.RELEASE</version> 
   </dependency> 
   发送代码: 
   amqpTemplate.convertAndSend(EXCHANGE,ROUTINGKEY,消息);注意exchang和routingkey，可以至少确定一个queue（此操作可在界面直接操作），发送消息后，可以在queue中查看信息。 
