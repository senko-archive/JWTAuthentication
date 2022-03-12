package com.senko.JWTAuthentication.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordEncoder {

    public static PasswordEncoder getUserPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
