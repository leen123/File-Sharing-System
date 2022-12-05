package com.example.demo2.request;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends RequestMap {
    private String userOrEmail;
   private String password;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void fromRequest(Map<String,String> header, Map<String,?> body) {
        userOrEmail=(String)body.get("userOrEmail");
        password= ((String)body.get("password"));
    }

    public String getUserOrEmail() {
        return userOrEmail;
    }

    public void setUserOrEmail(String userOrEmail) {
        this.userOrEmail = userOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
