package com.sim1zzo.microservices.camelmicroservicesa.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class GetCurrentTimeBeanClass {
    public String getCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }

    public String getTomorrowTime() {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        var i = 1;
        c.add(Calendar.DATE, i++);
        dt = c.getTime();
        return "Tomorrow time is: " + dt.toString();
    }

}
