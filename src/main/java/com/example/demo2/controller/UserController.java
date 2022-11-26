
package com.example.demo2.controller;

import com.example.demo2.model.entity.User;
import com.example.demo2.request.*;
import com.example.demo2.response.*;
import com.example.demo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /*@GetMapping("/get-user")
    public User getUser(@RequestParam int id ){
       // System.out.println("temp id get-user "+id);
        return userService.getUser(id);
    }*/
    @PostMapping("/add-user")
    public User save(@RequestBody User user ){
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete-user")
    public void delete(@RequestParam Integer id ){
        userService.delete(id);
    }
    @PostMapping("/update-user")
    public User update(@RequestBody User user ){
        return userService.saveUser(user);
    }
    @GetMapping("/get-all")
    public List<User> getAll(){
        return this.userService.getAll();
    }



    @PostMapping("/login")
    public void login(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        LoginRequest loginRequest= new LoginRequest();
        loginRequest.fromRequest(header,body);
        System.out.println(loginRequest.getUserOrEmail());
        System.out.println(loginRequest.getPassword());
        ResponseMap loginResponse=new LoginResponse();
        loginResponse.fromResponseBody();
        System.out.println(loginResponse.getBody());
    }
    @PostMapping("/register")
    public void register(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        RegisterRequest registerRequest= new RegisterRequest();
        registerRequest.fromRequest(header,body);
        System.out.println(registerRequest.getName());
        System.out.println(registerRequest.getUsername());
        System.out.println(registerRequest.getEmail());
        System.out.println(registerRequest.getPassword());
        ResponseMap registerResponse=new RegisterResponse();
        registerResponse.fromResponseBody();
        System.out.println(registerResponse.getBody());
    }
    @GetMapping("/get_user")
    public void getUser(@RequestHeader Map<String,String> header){
        GetUserRequest getUserRequest= new GetUserRequest();
        getUserRequest.fromRequest(header,null);
        System.out.printf("token :"+getUserRequest.token);
        ResponseMap getUserResponse=new GetUserResponse();
        getUserResponse.fromResponseBody();
        System.out.println(getUserResponse.getBody());

    }
    @GetMapping("/get_group_public")
    public void getGrouppublic(@RequestHeader Map<String,String> header){
        GetGroupPublicRequest getGroupPublicRequest= new GetGroupPublicRequest();
        getGroupPublicRequest.fromRequest(header,null);
        System.out.printf("token :"+getGroupPublicRequest.token);
        ResponseMap getGroupPublicResponse=new GetGroupPublicResponse();
        getGroupPublicResponse.fromResponseBody();
        System.out.println(getGroupPublicResponse.getBody());

    }
    @GetMapping("/get_group_private")
    public void getGroupPrivate(@RequestHeader Map<String,String> header){
        GetGroupPrivateRequest getGroupPrivateRequest= new GetGroupPrivateRequest();
        getGroupPrivateRequest.fromRequest(header,null);
        System.out.printf("token :"+getGroupPrivateRequest.token);
        ResponseMap getGroupPrivateResponse=new GetGroupPrivateResponse();
        getGroupPrivateResponse.fromResponseBody();
        System.out.println(getGroupPrivateResponse.getBody());

    }

    @GetMapping("/get_file")
    public void getFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetFileRequest getFileRequest= new GetFileRequest();
        getFileRequest.fromRequest(header,body);
        System.out.printf("token :"+getFileRequest.token);
        System.out.println(getFileRequest.getGroupid());
        ResponseMap getFileResponse=new GetFileResponse();
        getFileResponse.fromResponseBody();
        System.out.println(getFileResponse.getBody());

    }

    @GetMapping("/get_reports_file")
    public void getReportsFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetReportsFileRequest getReportsFileRequest= new GetReportsFileRequest();
        getReportsFileRequest.fromRequest(header,body);
        System.out.printf("token :"+getReportsFileRequest.token);
        System.out.println(getReportsFileRequest.getFileId());
        ResponseMap getReportsResponse=new GetReportsResponse();
        getReportsResponse.fromResponseBody();
        System.out.println(getReportsResponse.getBody());

    }

    @DeleteMapping("/delete_file")
    public void deleteFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        DeleteFileRequest deleteFileRequest= new DeleteFileRequest();
        deleteFileRequest.fromRequest(header,body);
        System.out.printf("token :"+deleteFileRequest.token);
        System.out.println(deleteFileRequest.getFileId());
        ResponseMap deleteFileResponse=new DeleteFileResponse();
        deleteFileResponse.fromResponseBody();
        System.out.println(deleteFileResponse.getBody());

    }
    @PostMapping("/create_file")
    public void createFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CreateFileRequest createFileRequest= new CreateFileRequest();
        createFileRequest.fromRequest(header,body);
        System.out.printf("token :"+createFileRequest.token);
        System.out.println(createFileRequest.getFile());
        ResponseMap createFileResponse=new CreateFileResponse();
        createFileResponse.fromResponseBody();
        System.out.println(createFileResponse.getBody());

    }

    @PostMapping("/create_group")
    public void createGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CreateGroupRequest createGroupRequest= new CreateGroupRequest();
        createGroupRequest.fromRequest(header,body);
        System.out.printf("token :"+createGroupRequest.token);
        System.out.println(createGroupRequest.getGroup());
        ResponseMap creatGroupResponse=new CreateGroupResponse();
        creatGroupResponse.fromResponseBody();
        System.out.println(creatGroupResponse.getBody());

    }

    @PostMapping("/check_in")
    public void checkIn(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CheckInRequest checkInRequest= new CheckInRequest();
        checkInRequest.fromRequest(header,body);
        System.out.println("token :"+checkInRequest.token);
        System.out.println("ListIdFile :"+checkInRequest.getlistFileId());
        ResponseMap checkinResponse=new CheckinResponse();
        checkinResponse.fromResponseBody();
        System.out.println(checkinResponse.getBody());
    }

    @PostMapping("/check_out")
    public void checkOut(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CheckOutRequest checkOutRequest= new CheckOutRequest();
        checkOutRequest.fromRequest(header,body);
        System.out.println("token :"+checkOutRequest.token);
        System.out.println("fileId :"+checkOutRequest.getfileId());
        ResponseMap checkoutResponse=new CheckoutResponse();
        checkoutResponse.fromResponseBody();
        System.out.println(checkoutResponse.getBody());

    }
}
