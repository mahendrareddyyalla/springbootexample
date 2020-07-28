package com.howtodoinjava.demo.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfiguration {

    /**
     * The {@link Jackson2JsonMessageConverter} to be used.
     *
     * @return {@link Jackson2JsonMessageConverter} to be used.
     */
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
