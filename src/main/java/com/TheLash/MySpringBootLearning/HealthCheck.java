package com.TheLash.MySpringBootLearning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("Hello")
    public String sayHello(){
        return "Hello SpringBoot";
    }
}
