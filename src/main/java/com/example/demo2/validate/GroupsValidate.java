package com.example.demo2.validate;

import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.model.entity.resours.TypeUserGroup;
import com.example.demo2.repository.GroupUserRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import com.example.demo2.request.LoginRequest;
import com.example.demo2.services.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GroupsValidate {

    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private GroupUserRepository groupUserRepository;
    @Autowired
    private UserRepository userRepository;

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


    public Map AddUserToGroupValidate(int groupId,int userId,int userIdAdder){
        Map valid = new HashMap();
        valid.put("status",201);
        valid.put("msg","add user to group succeeded");



        if(!groupsRepository.existsById(groupId)){
            valid.put("status",412);
            valid.put("msg","this  group not found");
        }
        else if(!userRepository.existsById(userId)){
            valid.put("status",412);
            valid.put("msg","this  user not found");

        }else {
            Groups groups=groupsRepository.findById(groupId).get();
            User user=userRepository.findById(userId).get();
            User userAdder=userRepository.findById(userIdAdder).get();
             if(groupUserRepository.existsByGroupsAndUser(groups,user)){
                valid.put("status",412);
                valid.put("msg","this  user already group join");
            }else if(!groups.getAddUserAll()&&groupUserRepository.existsByStateUserAndUser(TypeUserGroup.member.name(),userAdder)){
                valid.put("status",412);
                valid.put("msg"," not allowed for add this group");
            }
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
