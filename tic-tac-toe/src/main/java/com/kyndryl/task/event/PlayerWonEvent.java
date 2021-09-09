package com.kyndryl.task.event;

import org.springframework.context.ApplicationEvent;

public class PlayerWonEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4475987965003308341L;

	private final String message;
	
	public PlayerWonEvent(final Object source, final String message) {
		super(source);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
