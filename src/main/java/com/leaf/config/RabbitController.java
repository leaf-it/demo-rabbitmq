package com.leaf.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    @Autowired
    RabbitMqConfig rabbitMqConfig;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/rabbitmq/sendMessageForSimple")
    public String sendMessageForSimple(@RequestBody String message) {
        amqpTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);
        return "it is  ok!";
    }
}
