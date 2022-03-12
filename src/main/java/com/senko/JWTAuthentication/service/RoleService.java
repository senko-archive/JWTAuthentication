package com.senko.JWTAuthentication.service;

import com.senko.JWTAuthentication.model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);
    List<Role> getAllRoles();


}
