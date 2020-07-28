package com.howtodoinjava.demo.service.tasks;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmpSchedular {
    /**
     * The {@link Logger} to be used.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpSchedular.class);
    //@Scheduled(fixedDelayString = "${plan.clean}")
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void cleanup() {
        // Calculate the Date by subtracting two days.
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);

        // Retrieve the Date.
        Date date = calendar.getTime();

        // Delete the Plans
       System.out.println("emp schedular called");

        // Log the Operation.
        LOGGER.info("emp schedular called", date);
    }
}
