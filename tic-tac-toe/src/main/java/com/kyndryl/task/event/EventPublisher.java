package com.kyndryl.task.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventPublisher {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public <T> void  publishCustomEvent(final T message, final ApplicationEvent event) {
		System.out.println("Publishing " + event.getClass().getSimpleName() + ": " + message);
		applicationEventPublisher.publishEvent(event);
	}
}
