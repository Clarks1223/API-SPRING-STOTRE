package com.example.API_SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class CustomerController {
    //Aqui solo deben ir los controladores
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam(value = "name", defaultValue = "Pablo") String name) {
        return new Customer(counter.incrementAndGet(), String.format(template, name));
    }
}
