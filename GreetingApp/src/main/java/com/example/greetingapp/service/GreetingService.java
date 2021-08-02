package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String greetTemplate = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting greetUser(User user) {
        String message = "Hello," + user.toString();
        return new Greeting(counter.incrementAndGet(), message);
    }
}
