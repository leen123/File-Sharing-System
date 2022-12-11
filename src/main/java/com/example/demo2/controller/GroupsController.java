
package com.example.demo2.controller;

import com.example.demo2.dto.GroupUserDto;
import com.example.demo2.dto.GroupsDto;
import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.request.*;
import com.example.demo2.response.*;
import com.example.demo2.services.GroupsService;
import com.example.demo2.services.UserService;
import com.example.demo2.validate.GroupsValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/groups")
public class GroupsController {
    @Autowired
    private GroupsService groupsService;

    @Autowired
    private GroupsValidate groupsValidate;
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



    @PostMapping("/create_group")
    public ResponseEntity createGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CreateGroupRequest createGroupRequest= new CreateGroupRequest();
        CreateGroupResponse creatGroupResponse=new CreateGroupResponse();
        createGroupRequest.fromRequest(header,body);


        Map response= groupsValidate.CreateGroupValidate(createGroupRequest);
        if((int)response.get("status")==201){
            creatGroupResponse.getGroups().fromEntety(groupsService.createGroup(createGroupRequest));
            creatGroupResponse.fromResponseBody();
            response.put("body",creatGroupResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
       // System.out.println(response);
    }

    @DeleteMapping("/delete_group")
    public ResponseEntity deleteGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        DeleteGroupRequest deleteGroupRequest= new DeleteGroupRequest();
        DeleteGroupResponse deleteGroupResponse=new DeleteGroupResponse();
        deleteGroupRequest.fromRequest(header,body);

        Map response= groupsValidate.deleteGroupValidate(deleteGroupRequest);
        if((int)response.get("status")==200){
            groupsService.deleteGroup(deleteGroupRequest.getGroupId());
            deleteGroupResponse.fromResponseBody();
            response.put("body",deleteGroupResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
    }

    @GetMapping("/get_group_public")
    public ResponseEntity getGrouppublic(@RequestHeader Map<String,String> header){
        GetGroupPublicRequest getGroupPublicRequest= new GetGroupPublicRequest();
        GetGroupPublicResponse getGroupPublicResponse=new GetGroupPublicResponse();
        getGroupPublicRequest.fromRequest(header,null);
        Map response= groupsValidate.GetGroupValidate();

        if((int)response.get("status")==200){
            List<Groups> groupsList= groupsService.getAllPublic(getGroupPublicRequest);
            for (Groups group:
                 groupsList) {
                GroupsDto groupsDto=GroupsDto.builder().build();
                groupsDto.fromEntety(group);
                getGroupPublicResponse.getListGroupPublic().add(groupsDto);
            }

            getGroupPublicResponse.fromResponseBody();
            response.put("body",getGroupPublicResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        //System.out.println(response);

    }
    @GetMapping("/get_group_private")
    public ResponseEntity getGroupPrivate(@RequestHeader Map<String,String> header){
        GetGroupPrivateRequest getGroupPrivateRequest= new GetGroupPrivateRequest();
        GetGroupPrivateResponse getGroupPrivateResponse=new GetGroupPrivateResponse();
        getGroupPrivateRequest.fromRequest(header,null);

        Map response= groupsValidate.GetGroupValidate();
        if((int)response.get("status")==200){
            List<Groups> groupsList= new ArrayList();
            groupsList=groupsService.getAllPrivate(getGroupPrivateRequest);
            for (Groups group:
                    groupsList) {
                GroupsDto groupsDto=GroupsDto.builder().build();
                groupsDto.fromEntety(group);
                getGroupPrivateResponse.getListGroupPrivate().add(groupsDto);
            }
            getGroupPrivateResponse.fromResponseBody();
            response.put("body",getGroupPrivateResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        //System.out.println(response);
    }
    @PostMapping("/add_user_group")
    public ResponseEntity addUserForGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        AddUserForGroupRequest addUserForGroupRequest= new AddUserForGroupRequest();
        AddUserForGroupResponse addUserForGroupResponse=new AddUserForGroupResponse();
        addUserForGroupRequest.fromRequest(header,body);


        Map response= groupsValidate.AddUserToGroupValidate(addUserForGroupRequest.getGroupId(),addUserForGroupRequest.getUserId(),Integer.parseInt(addUserForGroupRequest.token));
        if((int)response.get("status")== 201){
            groupsService.addUserForGroup(addUserForGroupRequest.getGroupId(),addUserForGroupRequest.getUserId());
            addUserForGroupResponse.fromResponseBody();
            response.put("body",addUserForGroupResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        // System.out.println(response);
    }
    @DeleteMapping("/delete_user_group")
    public ResponseEntity deleteUserForGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        DeleteUserForGroupRequest deleteUserForGroupRequest= new DeleteUserForGroupRequest();
        DeleteUserForGroupResponse deleteUserForGroupResponse=new DeleteUserForGroupResponse();
        deleteUserForGroupRequest.fromRequest(header,body);


        Map response= groupsValidate.DeleteUserToGroupValidate(deleteUserForGroupRequest.getGroupId(),deleteUserForGroupRequest.getUserId(),Integer.parseInt(deleteUserForGroupRequest.token));
        if((int)response.get("status")== 201){
            groupsService.deleteUserForGroup(deleteUserForGroupRequest.getGroupId(),deleteUserForGroupRequest.getUserId());

            deleteUserForGroupResponse.fromResponseBody();
            response.put("body",deleteUserForGroupResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        // System.out.println(response);
    }

    @PostMapping("/get_user_group")
    public ResponseEntity getUserForGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetUserGroupRequest getUserGroupRequest= new GetUserGroupRequest();
        GetUserGroupResponse getUserGroupResponse=new GetUserGroupResponse();
        getUserGroupRequest.fromRequest(header,body);


        Map response= groupsValidate.GetUserToGroupValidate(getUserGroupRequest.getGroupId());
        if((int)response.get("status")== 200){
            List<GroupUser> groupUserList=groupsService.getUserForGroup(getUserGroupRequest.getGroupId());

            for (GroupUser groupUser : groupUserList){
                GroupUserDto groupUserDto=GroupUserDto.builder().build();
                groupUserDto.fromEntety(groupUser);
                getUserGroupResponse.getListGroupUser().add(groupUserDto);
            }
            getUserGroupResponse.fromResponseBody();
            response.put("body",getUserGroupResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
    }


}
