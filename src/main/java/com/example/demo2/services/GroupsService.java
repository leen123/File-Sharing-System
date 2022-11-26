package com.example.demo2.services;

import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {
    @Autowired
    private GroupsRepository groupsRepository;
    public Groups getGroup(int id){
        Optional<Groups> groups = this.groupsRepository.findById(id);
        return groups.orElse(null);
    }
    public Groups saveGroup(Groups groups){

        System.out.println(groups);
        return this.groupsRepository.save(groups);

    }
    public List<Groups> getAll(){
        return this.groupsRepository.findAll();
    }

    public void delete(int id){
        this.groupsRepository.deleteById(id);
    }
}
