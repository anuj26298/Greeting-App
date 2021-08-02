package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService implements IGreetingService{
    @Autowired
    GreetingRepo greetingRepo;

    @Override
    public Greeting greetUser(User user) {
        String message = user.getFirstName() + " " + user.getLastName();
        return greetingRepo.save(new Greeting(message));
    }

    @Override
    public Greeting getGreetById(long id) {
        return greetingRepo.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreets() {
        return  greetingRepo.findAll();
    }

    @Override
    public Greeting updateGreeting(Long id, User user) {
        String message = user.getFirstName() + " " + user.getLastName();
        return greetingRepo.findById(id)
                .map(greeting -> {
                    greeting.setMessage(message);
                    return greetingRepo.save(greeting);
                }).get();
    }

    @Override
    public Greeting deleteGreet(Long id) {
        return greetingRepo.findById(id)
                .map(greeting -> {
                    this.greetingRepo.deleteById(id);
                    return greeting;
                }).get();
    }
}
