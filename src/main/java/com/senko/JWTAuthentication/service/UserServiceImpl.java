package com.senko.JWTAuthentication.service;

import com.senko.JWTAuthentication.model.Role;
import com.senko.JWTAuthentication.model.User;
import com.senko.JWTAuthentication.repository.RoleRepository;
import com.senko.JWTAuthentication.repository.UserRepository;
import com.senko.JWTAuthentication.util.UserPasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserPasswordEncoder userPasswordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database", user.getUsername());
        PasswordEncoder passwordEncoder = userPasswordEncoder.getUserPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("adding role {} to user {}", rolename, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRole(rolename);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
}
