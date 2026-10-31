package com.doneby.market.controller;

import com.doneby.market.domain.Address;
import com.doneby.market.domain.User;
import com.doneby.market.repository.AddressRepository;
import com.doneby.market.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    private AddressRepository addressRepository;

    public UserController(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

   // @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping(path="/{id}")
    public User getUser(@PathVariable("id") long id) {
        if(id == 3) {
            return null;
        }
        System.out.println("ID: " + id + "; " + "adfsdgfs".intern());
//        var arena = Arena.global();
//        arena.allocate()
        //ThreadLocal.withInitial((x) -> System.out.println(x));
        try{
            User user = userRepository.getReferenceById(id);
            System.out.println(user);
            return user;
            //return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            LOG.info("Err: " + e.getMessage());
            // ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           // throw new HttpClientErrorException(HttpStatusCode.valueOf(404));
        }//HttpStatusCode
        return null;
    }

   // @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping(path="/")
    public User addUser(@RequestBody User user) {
        System.out.println("User: " + user);
        return userRepository.save(user);
    }

    @PutMapping(path="/")
    public User updateUser(@RequestBody User user) {
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
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @PostMapping(path="/{id}/address")
    @ExceptionHandler
    public Address addAddress(@RequestBody Address address, @PathVariable("id") Long id) {
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
