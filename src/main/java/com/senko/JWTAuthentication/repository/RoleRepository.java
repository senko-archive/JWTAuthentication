package com.senko.JWTAuthentication.repository;

import com.senko.JWTAuthentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
