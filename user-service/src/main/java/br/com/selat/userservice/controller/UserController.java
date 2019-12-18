package br.com.selat.userservice.controller;

import br.com.selat.userservice.entities.User;
import br.com.selat.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findById(id).orElse(new User());
    }
}
