package com.kyndryl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class Factory {
	
	private final DefaultListableBeanFactory context;
	
	@Autowired
	public Factory(final DefaultListableBeanFactory context) {
		this.context = context;
	}
	
	public Object getBean(final Class<?> clazz, final String qualifier, final Object ...arguments) {
		return context.getBean(qualifier + clazz.getSimpleName(), arguments);
	}
	
}   