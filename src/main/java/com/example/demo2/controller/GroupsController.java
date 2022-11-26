
package com.example.demo2.controller;

import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.services.GroupsService;
import com.example.demo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController {
    @Autowired
    private GroupsService groupsService;
    @GetMapping("/get-group")
    public Groups getUser(@RequestParam int id ){
       // System.out.println("temp id get-user "+id);
        return groupsService.getGroup(id);
    }
    @PostMapping("/add-group")
    public Groups save(@RequestBody Groups groups ){
        return groupsService.saveGroup(groups);
    }

    @DeleteMapping("/delete-group")
    public void delete(@RequestParam Integer id ){
        groupsService.delete(id);
    }
    @PostMapping("/update-group")
    public Groups update(@RequestBody Groups groups ){
        return groupsService.saveGroup(groups);
    }
    @GetMapping("/get-all")
    public List<Groups> getAll(){
        return this.groupsService.getAll();
    }
}
