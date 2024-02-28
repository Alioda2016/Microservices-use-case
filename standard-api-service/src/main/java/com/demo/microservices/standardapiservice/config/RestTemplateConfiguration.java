package com.demo.microservices.standardapiservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
//    used for the same trace id i both logs for two microservices taking to each other
    @Bean
    public RestTemplate buildResttemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
