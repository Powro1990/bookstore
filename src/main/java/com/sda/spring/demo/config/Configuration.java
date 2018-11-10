package com.sda.spring.demo.config;

import com.sda.spring.demo.model.Person;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Person personBean(){
        return new Person();
    }
}
