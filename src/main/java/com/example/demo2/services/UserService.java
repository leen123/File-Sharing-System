package com.example.demo2.services;

import com.example.demo2.model.entity.User;
import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(int id){
       // System.out.println("service get user id "+id);
     //   System.out.println("service get user "+this.userRepository.findById(id));

        Optional<User> user = this.userRepository.findById(id);
        return user.orElse(null);
    }
    public User saveUser(User user){
        System.out.println("user save service "+user );
        return this.userRepository.save(user);

    }
    public List<User> getAll(){
        System.out.print(this.userRepository.findAll());
        return this.userRepository.findAll();
    }

    public void delete(int id){

        this.userRepository.deleteById(id);
    }



}
