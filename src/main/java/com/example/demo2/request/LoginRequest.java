package com.example.demo2.request;


import java.util.Map;

public class LoginRequest implements RequestMap {
   public String userOrEmail;
    public  String password;

    @Override
    public void fromRequest(Map<String,String> header, Map<String,String> body) {
        userOrEmail=body.get("userOrEmail");
    }
}
