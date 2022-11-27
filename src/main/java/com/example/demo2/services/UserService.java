package com.example.demo2.services;

import com.example.demo2.model.entity.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(int id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElse(null);
    }
    public User saveUser(User user){
       // System.out.println("user save service "+user );
        return this.userRepository.save(user);

    }
    public User login(LoginRequest loginRequest){
        if(userRepository.existsByEmail(loginRequest.getUserOrEmail()).get())
            return userRepository.findByEmail(loginRequest.getUserOrEmail()).get();
        else
            return userRepository.findByUserName(loginRequest.getUserOrEmail()).get();

    }
    public List<User> getAll(){
        System.out.print(this.userRepository.findAll());
        return this.userRepository.findAll();
    }

    public void delete(int id){

        this.userRepository.deleteById(id);
    }



}
