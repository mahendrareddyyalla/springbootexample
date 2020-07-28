package com.howtodoinjava.demo.service.listener;

import java.util.Objects;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.howtodoinjava.demo.service.event.EmloyeeEvent;

@Service
public class EmployeeListenerEvent {

	@Async
    @TransactionalEventListener(classes = EmloyeeEvent.class)
    public void handleEvent(EmloyeeEvent event) {
		 Objects.requireNonNull(event, "WorkOrderEscalatedEvent cannot be null.");
		System.out.println("employeelistener called");
}
}

