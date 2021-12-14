package com.sim1zzo.microservices.camelmicroservices.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        //timer
//        from("timer:active-mq-timer?period=10000")
//        //queue
//                .transform().constant("THIS IS A MESSAGE FOR ACTIVE MQ")
//                .log("${body}")
//                .to("activemq:my-activemq-queue");

//        from("file:files/json")
//        .log("${body}")
//        .to("activemq:my-activemq-queue");

        from("file:files/xml")
        .log("${body}")
        .to("activemq:my-activemq-xml-queue");
    }
}
