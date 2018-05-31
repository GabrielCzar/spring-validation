package com.gabrielczar.springvalidations.configurations;

import com.gabrielczar.springvalidations.validators.BeforeCreateUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;


@Configuration
public class ApplicationConfiguration extends RepositoryRestConfigurerAdapter {
    private final Validator validator;

    @Autowired
    public ApplicationConfiguration(@Qualifier("defaultValidator") Validator validator) {
        this.validator = validator;
    }

    @Bean
    public BeforeCreateUserValidator beforeCreateUserValidator(){
        return new BeforeCreateUserValidator();
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeCreate", beforeCreateUserValidator());
    }
}
