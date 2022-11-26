package com.example.demo2.request;

import java.util.Map;

public class RegisterRequest extends RequestMap {
    private String name;
    private String username;
    private String email;
    private String password;

    @Override
    public void fromRequest(Map<String,String> header, Map<String,?> body) {
        name=(String) body.get("name");
        username=(String)body.get("username");
        email=(String)body.get("email");
        password=(String)body.get("password");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

