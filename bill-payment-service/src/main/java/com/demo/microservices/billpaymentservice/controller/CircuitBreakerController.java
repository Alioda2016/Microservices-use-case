package com.demo.microservices.billpaymentservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/retry-api")
    @Retry(name = "retry-api", fallbackMethod = "hardCodedResponse")
    public String retryApi() {
        logger.info("retry api called");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }

    @GetMapping("/circuit-breaker")
    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
    public String circuitBreakerApi() {
        logger.info("circuit breaker api called");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }

    @GetMapping("/rate-limiter")
    @RateLimiter(name = "default") //10s -> 1000 calls
    public String rateLimiterApi() {
        logger.info("sample api call received");
        return "rate limiter API";
    }

    @GetMapping("/bulk-head") // set max concurrent requests
    @RateLimiter(name = "default") //10s -> 1000 calls
    public String bulkHeadApi() {
        logger.info("sample api call received");
        return "rate limiter API";
    }

    public String hardCodedResponse(Exception ex) {
        return "fallback response";
    }
}
