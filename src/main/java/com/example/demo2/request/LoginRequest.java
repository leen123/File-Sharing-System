package com.example.demo2.request;


import java.util.Map;

public class LoginRequest extends RequestMap {
    private String userOrEmail;
   private String password;


    @Override
    public void fromRequest(Map<String,String> header, Map<String,?> body) {
        userOrEmail=(String)body.get("userOrEmail");
        password=(String)body.get("password");
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
