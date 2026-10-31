package com.doneby.market.service;

import com.doneby.market.domain.User;
import com.doneby.market.repository.AddressRepository;
import com.doneby.market.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsManager {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDetails user) {
        User dbyUser = (User) user;
        System.out.println("User: " + dbyUser);
        userRepository.save(dbyUser);
    }

    @Override
    public void updateUser(UserDetails user) {
        User dbyUser = (User) user;
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(@Nullable String oldPassword, @Nullable String newPassword) {

    }

    @Override
    public boolean userExists(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.getUserByEmail(email);
    }
}
