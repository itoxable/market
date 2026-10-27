package com.doneby.market.controller;

import com.doneby.market.domain.Address;
import com.doneby.market.domain.User;
import com.doneby.market.repository.AddressRepository;
import com.doneby.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping(path="/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Long id) {
        System.out.println("ID: " + id);
        return userRepository.getReferenceById(id);
    }

    @PostMapping(path="/")
    public @ResponseBody User addUser(@RequestBody User user) {
        System.out.println("User: " + user);
        return userRepository.save(user);
    }

    @PutMapping(path="/")
    public @ResponseBody User updateUser(@RequestBody User user) {
        User currentUser = userRepository.getReferenceById(user.getId());
        System.out.println("User: " + user);
        return userRepository.save(user);
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        System.out.println("Delete ID: " + id);
        userRepository.deleteById(id);
    }

    @GetMapping(path="/")
    public @ResponseBody List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping(path="/{id}/address")
    public @ResponseBody Address addAddress(@RequestBody Address address, @PathVariable("id") Long id) {
        User currentUser = userRepository.getReferenceById(id);
        System.out.println("User: " + currentUser);
        address.setUserId(currentUser.getId());
        return addressRepository.save(address);
    }

    @DeleteMapping(path="/{id}/address/{userId}")
    public void deleteUserAddress(@PathVariable("id") Long id, @PathVariable("userId") Long userId) {
        System.out.println("Delete ID: " + id);
        addressRepository.deleteById(id);
    }
}
