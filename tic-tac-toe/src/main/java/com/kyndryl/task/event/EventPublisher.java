package com.kyndryl.task.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

import com.kyndryl.task.dto.PlayDto;

@Configuration
public class EventPublisher {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void publishCustomEvent(final PlayDto playDto) {
		System.out.println("Publishing eventData: " + playDto);
		final NextMoveEvent customSpringEvent = new NextMoveEvent(playDto);
		applicationEventPublisher.publishEvent(customSpringEvent);
	}
}
