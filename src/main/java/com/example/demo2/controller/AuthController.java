package com.example.demo2.controller;

//import com.example.demo2.JwtTokenUtil;
import com.example.demo2.LoginRequest;
import com.example.demo2.LoginResponse;

import com.example.demo2.model.entity.User;
import com.example.demo2.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Auth")
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @Operation(
            summary = "Login",
            parameters = @Parameter(name = "Accept-Language", in = ParameterIn.HEADER, example = "en")
    )
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        var token ="kk";// authService.login(request);

        var response = new LoginResponse();

        response.setToken(token);
        response.setUser(User.builder().build());
      //  response.setUser(userService.get(jwtTokenUtil.getUserId(token)));

        return response;
    }
}
