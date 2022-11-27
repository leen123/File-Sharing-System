
package com.example.demo2.controller;

import com.example.demo2.dto.GroupsDto;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import com.example.demo2.request.GetGroupPublicRequest;
import com.example.demo2.response.CreateGroupResponse;
import com.example.demo2.response.GetGroupPrivateResponse;
import com.example.demo2.response.GetGroupPublicResponse;
import com.example.demo2.response.ResponseMap;
import com.example.demo2.services.GroupsService;
import com.example.demo2.services.UserService;
import com.example.demo2.validate.GroupsValidate;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CreateGroupRequest createGroupRequest= new CreateGroupRequest();
        CreateGroupResponse creatGroupResponse=new CreateGroupResponse();
        createGroupRequest.fromRequest(header,body);


        Map response= groupsValidate.CreateGroupValidate(createGroupRequest);
        if((int)response.get("status")==201){
            creatGroupResponse.getGroups().fromEntety(groupsService.createGroup(createGroupRequest));
            creatGroupResponse.fromResponseBody();
            response.put("body",creatGroupResponse.getBody());
        }

        System.out.println(response);
    }
    @GetMapping("/get_group_public")
    public void getGrouppublic(@RequestHeader Map<String,String> header){
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

        System.out.println(response);

    }
    @GetMapping("/get_group_private")
    public void getGroupPrivate(@RequestHeader Map<String,String> header){
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
        System.out.println(response);
    }


}
