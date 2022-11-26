package com.example.demo2.response;

import com.example.demo2.model.entity.User;

public class LoginResponse extends ResponseMap{
    String token;
    User user;

    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("token",token);
        body.put("user",user);
    }
}
