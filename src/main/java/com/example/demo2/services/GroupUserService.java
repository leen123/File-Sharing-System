package com.example.demo2.services;

import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.repository.GroupUserRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import com.example.demo2.request.GetGroupPublicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupUserService {
    @Autowired
    private GroupUserRepository groupUserRepository;

    @Autowired
    private UserService userService;
   // @Autowired
 //   private GroupsService groupsService;

    public List<GroupUser> getGroupUser(GetGroupPrivateRequest getGroupPrivateRequest){
        Optional<List<GroupUser>> groupUserList = this.groupUserRepository.findAllByUser(
                userService.getUser(
                        Integer.parseInt(getGroupPrivateRequest.token))
        );
        return groupUserList.orElse(null);
    }
    public List<Groups> getGroupByUser(User user){
        Optional<List<GroupUser>> groupUserList = this.groupUserRepository.findAllByUser(user);
         List<Groups> groupsList=new ArrayList<>();
        for(GroupUser groupUser : groupUserList.get()){
            groupsList.add(groupUser.getGroups());
        }
        return groupsList;
    }
    public GroupUser saveGroupUser(CreateGroupRequest createGroupRequest,Groups groups,String stateUser){
        User user= userService.getUser(Integer.parseInt(createGroupRequest.token));
        GroupUser groupUser =groupUserRepository.save( GroupUser.builder().groups(groups).user(user).stateUser(stateUser).build());
        return groupUser;
    }

}
