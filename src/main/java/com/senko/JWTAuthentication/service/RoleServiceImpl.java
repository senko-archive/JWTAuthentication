package com.senko.JWTAuthentication.service;

import com.senko.JWTAuthentication.model.Role;
import com.senko.JWTAuthentication.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getRole());
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        log.info("returning all roles");
        List<Role> allRoles = roleRepository.findAll();
        return allRoles;
    }
}
