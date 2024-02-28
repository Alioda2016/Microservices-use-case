package com.demo.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get").
                        filters(f -> f.addRequestParameter("MyHeader", "MyUri")
                                .addRequestParameter("param", "value"))
                                .uri("http://httpbin.org:80"))
//                 lb is load balancer
                .route(p -> p.path("/standard-service/**").uri("lb://standard-api"))
                .build();
    }
}
