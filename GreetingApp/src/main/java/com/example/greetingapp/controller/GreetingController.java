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
    public Greeting greeting(@RequestParam(value = "fname", defaultValue = "Hello")  String firstName,
                             @RequestParam(value ="lname", defaultValue = "World") String lastName ){
        User user = new User(firstName,lastName);
        return greetingService.greetUser(user);
    }
}
