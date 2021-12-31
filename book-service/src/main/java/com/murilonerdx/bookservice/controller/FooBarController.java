package com.murilonerdx.bookservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book-service")
public class FooBarController {

    @GetMapping("/foo-bar")
//    @Retry(name="foo-bar", fallbackMethod="fallbackMethod")
    @CircuitBreaker(name="default", fallbackMethod="fallbackMethod")
    @RateLimiter(name="default")
    public String fooBar(){
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return forEntity.getBody();
    }

    public String fallBackMethod(Exception exception) {
        return "fallbackMethod foo-bar!!!";
    }
}
