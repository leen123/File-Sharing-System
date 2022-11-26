
package com.example.demo2.controller;

import com.example.demo2.model.entity.User;
import com.example.demo2.request.LoginRequest;
import com.example.demo2.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get-user")
    public User getUser(@RequestParam int id ){
       // System.out.println("temp id get-user "+id);
        return userService.getUser(id);
    }
    @PostMapping("/add-user")
    public User save(@RequestBody User user ){
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete-user")
    public void delete(@RequestParam Integer id ){
        userService.delete(id);
    }
    @PostMapping("/update-user")
    public User update(@RequestBody User user ){
        return userService.saveUser(user);
    }
    @GetMapping("/get-all")
    public List<User> getAll(){
        return this.userService.getAll();
    }



    @PostMapping("/login")
    public void login(@RequestHeader Map<String,String> header, @RequestBody Map<String,String> body){
        LoginRequest loginRequest= new LoginRequest();
        loginRequest.fromRequest(header,body);
        System.out.println(loginRequest.userOrEmail);
    }
}
