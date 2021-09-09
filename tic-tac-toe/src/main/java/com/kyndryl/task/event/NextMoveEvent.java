package com.kyndryl.task.event;

import org.springframework.context.ApplicationEvent;

public class NextMoveEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4475987965003308341L;

	public NextMoveEvent(final Object source) {
		super(source);
	}
}
