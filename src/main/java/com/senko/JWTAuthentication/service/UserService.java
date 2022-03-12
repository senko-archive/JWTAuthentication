package com.senko.JWTAuthentication.service;

import com.senko.JWTAuthentication.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}
