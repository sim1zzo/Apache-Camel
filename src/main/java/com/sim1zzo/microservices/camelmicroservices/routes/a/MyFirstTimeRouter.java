package com.sim1zzo.microservices.camelmicroservices.routes.a;

import com.sim1zzo.microservices.camelmicroservices.beans.GetCurrentTimeBeanClass;
import com.sim1zzo.microservices.camelmicroservices.beans.LoggingBean;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MyFirstTimeRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBeanClass getCurrentTimeBeanClass;

    @Autowired
    private LoggingBean loggingBean;

    @Override
    public void configure() throws Exception {
        // supposing we are reading from a:
        // queue then make some transformation ->
        // transformation then save it to db ->
        // DB


        from("timer:first-timer")
//        .transform().constant("This is a message coming from a constant" + LocalDateTime.now())
                .bean(getCurrentTimeBeanClass, "getCurrentTime")
                .to("log:sto-cazzo").end();


        from("timer:second-timer")
                .transform().constant("This is the second-timer")
                .bean(getCurrentTimeBeanClass, "getTomorrowTime")
                .to("log:second-timer")
                .end();

        from("timer:third-timer")
                .log("${body}")
                .transform().constant("Checking the third timer")
                .log("${body}")
                .bean(getCurrentTimeBeanClass, "getTomorrowTime")
                .log("${body}")
                .bean(loggingBean)
                .log("${body}")
                .transform().constant("Here we have a process created without a bean")
                .process(new LogginClass())
                .log("${body}")
                .to("log:third-timer")
                .end();

    }

    class LogginClass implements org.apache.camel.Processor {
        private Logger logger = LoggerFactory.getLogger(LogginClass.class);

        @Override
        public void process(Exchange exchange) throws Exception {
            logger.info("LogginClass no bean, {}", exchange.getMessage().getBody());
        }
    }
}



