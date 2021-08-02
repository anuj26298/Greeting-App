package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        User user = new User(name, "Kumar");
        return greetingService.greetUser(user);
    }
}
