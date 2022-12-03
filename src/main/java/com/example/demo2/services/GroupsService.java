package com.example.demo2.services;

import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.model.entity.resours.TypeUserGroup;
import com.example.demo2.repository.GroupUserRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import com.example.demo2.request.GetGroupPublicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {
    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private GroupUserService groupUserService;

    public Groups getGroup(int id){
        Optional<Groups> groups = this.groupsRepository.findById(id);
        return groups.orElse(null);
    }

    public Groups saveGroup(Groups groups){
        groups.setUpdatedAt(new Date(System.currentTimeMillis()));
        return this.groupsRepository.save(groups);

    }
    public List<Groups> getAll(){
        return this.groupsRepository.findAll();
    }
    public List<Groups> getAllPrivate(GetGroupPrivateRequest getGroupPrivateRequest){
        User user= userService.getUser(Integer.parseInt(getGroupPrivateRequest.token));
        List<Groups> groupsList=groupUserService.getGroupByUser(user);

        return groupsList;
    }
    public List<Groups> getAllPublic(GetGroupPublicRequest getGroupPublicRequest){
        return this.groupsRepository.findAllByTypeGroup("public");
    }
    public void delete(int id){
        this.groupsRepository.deleteById(id);
    }
    @Transactional
    public Groups createGroup(CreateGroupRequest createGroupRequest){
        createGroupRequest.getGroup().setUser(userService.getUser(Integer.parseInt(createGroupRequest.token)));
        Groups groups= this.groupsRepository.save(createGroupRequest.getGroup());
        GroupUser groupUser= groupUserService.saveGroupUser(createGroupRequest,groups, TypeUserGroup.owner.name());
        return  groups;
    }
    public Groups addUserForGroup(int groupId,int userId){
        Groups groups= this.groupsRepository.findById(groupId).get();
         GroupUser groupUser= groupUserService.addUserForGroup(groups,userId);
        return  groups;
    }
}
