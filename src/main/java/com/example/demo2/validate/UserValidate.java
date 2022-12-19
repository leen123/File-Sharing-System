package com.example.demo2.validate;

import antlr.Token;
import com.example.demo2.model.entity.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.request.LoginRequest;
import com.example.demo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserValidate {

    @Autowired
    private UserRepository userRepository;
    public Map loginValidate(LoginRequest loginRequest){
        Map valid = new HashMap();
        if(!userRepository.existsByEmail(loginRequest.getUserOrEmail()).get()
        &&!userRepository.existsByUserName(loginRequest.getUserOrEmail()).get()){
            valid.put("status",412);
            valid.put("msg","this email or user name not found");
        }
        else{
            User user1;
           if(userRepository.existsByEmail(loginRequest.getUserOrEmail()).get())
               user1=userRepository.findByEmail(loginRequest.getUserOrEmail()).get();
           else{
               user1=userRepository.findByUserName(loginRequest.getUserOrEmail()).get();
           }

            System.out.println(user1.getPassword());
            System.out.println(loginRequest.getPassword());
           if(!user1.getPassword().equals(loginRequest.getPassword())){
               valid.put("status",412);
               valid.put("msg","password invalid");
           }
           else {
                valid.put("status",200);
                valid.put("msg","login succeeded");
            }
        }

        return valid;
    }


    public Map registerValidate(User user){
        Map valid = new HashMap();
        if(userRepository.existsByEmail(user.getEmail()).get()){
            valid.put("status",412);
            valid.put("msg","this email already found");
        }
        else if(userRepository.existsByUserName(user.getUserName()).get()){
            valid.put("status",412);
            valid.put("msg","this  user name already found");
        }
        else if(user.getPassword().length()<6){
                valid.put("status",412);
                valid.put("msg","password short");
        }else {
            valid.put("status",201);
            valid.put("msg","register succeeded");
        }

        return valid;
    }
    public Map getUserValidate(String token){

        Map valid = new HashMap();
        if(!userRepository.existsById(Integer.parseInt(token))){
            valid.put("status",401);
            valid.put("msg","succeeded");
        }
        else {
            valid.put("status",200);
            valid.put("msg","token succeeded");
        }
        return valid;
    }
    public Map getAllUserValidate(){

        Map valid = new HashMap();
            valid.put("status",200);
            valid.put("msg","get all user");
        return valid;
    }


}
