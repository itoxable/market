package com.doneby.market.controller;

import com.doneby.market.domain.User;
import com.doneby.market.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/{id}")
    public @ResponseBody User getUser(@PathParam("Id") Long id) {
        return userRepository. getReferenceById(id);
    }

    @PostMapping(path="/")
    public @ResponseBody User addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }
}
