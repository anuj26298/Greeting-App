package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String greetTemplate = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepo greetingRepo;

    @Override
    public Greeting greetUser(User user) {
        String message = user.getFirstName() + " " + user.getLastName();
        return greetingRepo.save(new Greeting(counter.incrementAndGet(), message));
    }
}
