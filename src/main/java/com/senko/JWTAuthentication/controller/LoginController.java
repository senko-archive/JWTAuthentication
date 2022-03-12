package com.senko.JWTAuthentication.controller;

import com.senko.JWTAuthentication.security.PasswordCheckUserDetailService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public LoginTokenResponse login(@RequestBody LoginRequest loginRequest) {

        System.out.println("Login rest calldasin");

        if(loginRequest == null) {
            throw new IllegalArgumentException("No credentials provided");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return null;

    }

    @GetMapping("/ping")
    public String ping() {
        System.out.println("pong is working");
        return "pong";
    }
}
