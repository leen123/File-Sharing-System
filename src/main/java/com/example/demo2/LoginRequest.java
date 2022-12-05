package com.example.demo2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {
    @NotBlank(message = "Not Blank")
    private String email;

    @NotBlank(message = "Not Blank")
    private String password;
}
