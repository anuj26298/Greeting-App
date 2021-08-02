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
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.greetUser(user);
    }
    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetById(id);
    }
    @PutMapping("/greeting/{id}")
    public Greeting updateGreetingById(@PathVariable Long id, @RequestBody User user){
        return greetingService.updateGreeting(id, user);
    }

    @DeleteMapping("/greeting/{id}")
    public Greeting deleteGreetById(@PathVariable Long id){
        return greetingService.deleteGreet(id);
    }
}
