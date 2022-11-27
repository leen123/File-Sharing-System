package com.example.demo2.validate;

import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.User;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import com.example.demo2.request.LoginRequest;
import com.example.demo2.services.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GroupsValidate {

    @Autowired
    private GroupsRepository groupsRepository;
    public Map CreateGroupValidate(CreateGroupRequest createGroupRequest){
        Map valid = new HashMap();
        if(groupsRepository.existsByName(createGroupRequest.getGroup().getName())){
            valid.put("status",412);
            valid.put("msg","this name group already found");
        }
        else{
                valid.put("status",201);
                valid.put("msg","create group succeeded");
        }

        return valid;
    }
    public Map GetGroupValidate(){
        Map valid = new HashMap();
        if(false){

        }
        else{
                valid.put("status",200);
                valid.put("msg","Get groups succeeded");
        }

        return valid;
    }
    public Map GetGroupValidatePrivate(GetGroupPrivateRequest getGroupPrivateRequest){
        Map valid = new HashMap();
        if(false){

        }
        else{
            valid.put("status",200);
            valid.put("msg","Get groups succeeded");
        }

        return valid;
    }



}
