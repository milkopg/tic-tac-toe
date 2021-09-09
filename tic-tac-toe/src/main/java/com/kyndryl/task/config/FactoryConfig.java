package com.kyndryl.task.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kyndryl.task.factory.Factory;

@Configuration
public class FactoryConfig {

	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor(
			final ConfigurableListableBeanFactory configurableBeanFactory) {
		return processor -> {
			final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableBeanFactory;
			final Factory factory = new Factory(beanFactory);
			createFactory(factory);
			
			
		};
	}
	
	@Bean
	public static Factory createFactory(final Factory factory) {
		return factory;
	}
}
