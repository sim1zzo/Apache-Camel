package com.sim1zzo.microservices.camelmicroservices.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingBean {
    private Logger logger = LoggerFactory.getLogger(LoggingBean.class);

    public void process(String message){
        logger.info("LoggingBean {}", message);
    }
}
