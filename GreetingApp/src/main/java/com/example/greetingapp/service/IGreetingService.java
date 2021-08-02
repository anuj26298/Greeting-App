package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting greetUser(User user);
    Greeting getGreetById(long id);
    List<Greeting> getAllGreets();
    Greeting updateGreeting(Long id, User user);
    Greeting deleteGreet(Long id);
}
