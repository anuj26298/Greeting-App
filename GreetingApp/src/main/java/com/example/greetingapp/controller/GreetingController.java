package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String greetTemplate = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(greetTemplate,name));
    }

    @PostMapping("/post_greeting")
    public Greeting postGreeting(@RequestBody Greeting greeting){
        return greeting;
    }

    @PutMapping("/put_mapping")
    public Greeting putGreeting(@PathVariable long id, @RequestParam(value = "name") String name){
        return new Greeting(id, String.format(greetTemplate,name));
    }
}
