package edu.mum.ea.config;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {

	@Autowired
	private MessageSource messageSource;

	@Bean
	public Validator localValidatorFactoryBean() {
		LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
		v.setValidationMessageSource(messageSource);
		return v;
	}

}
