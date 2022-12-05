package com.example.demo2;

import com.example.demo2.model.entity.User;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginResponse {
    @NotNull
    private String token;

    @NotNull
    private User user;
}
