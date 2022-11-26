package com.example.demo2.controller;/*
package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.services.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController
{
    @Autowired
    private SignService signService;
    @GetMapping("/get-user")
    public User getUser(@RequestParam Integer id ){
        return signService.getUser(1);
    }
}
*/