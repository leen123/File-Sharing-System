
package com.example.demo2.controller;

import com.example.demo2.Demo2Application;
import com.example.demo2.dto.GroupUserDto;
import com.example.demo2.dto.UserDto;
import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.User;
import com.example.demo2.request.*;
import com.example.demo2.response.*;
import com.example.demo2.services.UserService;
import com.example.demo2.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidate userValidate;
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
    public ResponseEntity getAll(@RequestHeader Map<String,String> header){
        GetAllUserResponse getAllUserResponse=new GetAllUserResponse();

        Map response= userValidate.getAllUserValidate();
        if((int)response.get("status")== 200){
            List<User> userList=this.userService.getAll();

            for (User user : userList){
                UserDto userDto=UserDto.builder().build();
                userDto.fromEntety(user);
                getAllUserResponse.getListUser().add(userDto);
            }
            getAllUserResponse.fromResponseBody();
            response.put("body",getAllUserResponse.getBody());
        }
        return ResponseMap.responseEntity(response);

    }



    @PostMapping("/login")
    public ResponseEntity login(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        LoginRequest loginRequest= new LoginRequest();
        LoginResponse loginResponse=new LoginResponse();
        loginRequest.fromRequest(header,body);
        System.out.println(loginRequest);

        Map response= userValidate.loginValidate(loginRequest);
        if((int)response.get("status")==200){
            loginResponse.getUserDto().fromEntety(userService.login(loginRequest));
            loginResponse.fromResponseBody();
            response.put("body",loginResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        // System.out.println(response);
    }
    private static Logger log = LoggerFactory.getLogger(Demo2Application.class);
    @RequestMapping("**")
    public void temp(){
        log.info("/Access/greeting");
        log.trace("/Access/greeting");
        log.error("/Access/greeting");
        System.out.println("dddd");
    }
    @Value("sever.port")
    String address;

    @GetMapping("/hello")
    public String hello() {
        return String.format("Hello from instance %s", address);
    }
    @RequestMapping("/load")
    public ResponseEntity load(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("load from instance %s", address));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        RegisterRequest registerRequest= new RegisterRequest();
        RegisterResponse registerResponse=new RegisterResponse();
        registerRequest.fromRequest(header,body);

        User user= User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .userName(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .typeUser("user").build();
        Map response= userValidate.registerValidate(user);
        if((int)response.get("status")==201){
            registerResponse.getUserDto().fromEntety(userService.saveUser(user));
            registerResponse.fromResponseBody();
            response.put("body",registerResponse.getBody());
        }


        return ResponseMap.responseEntity(response);
       // return ResponseEntity.status((int)response.get("status")).body(response);
    }


    @GetMapping("/get_user")
    public ResponseEntity getUser(@RequestHeader Map<String,String> header){
        GetUserRequest getUserRequest= new GetUserRequest();
        GetUserResponse getUserResponse=new GetUserResponse();
        getUserRequest.fromRequest(header,null);

        Map response= userValidate.getUserValidate(getUserRequest.token);
        if((int)response.get("status")==200){
            getUserResponse.getUserDto().fromEntety(userService.getUser(Integer.parseInt(getUserRequest.token)));
            getUserResponse.fromResponseBody();
            response.put("body",getUserResponse.getBody());
        }

       // System.out.println(response);
        return ResponseMap.responseEntity(response);
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

    /*@GetMapping("/get_file")
    public void getFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetFileRequest getFileRequest= new GetFileRequest();
        getFileRequest.fromRequest(header,body);
        System.out.printf("token :"+getFileRequest.token);
        System.out.println(getFileRequest.getGroupid());
        ResponseMap getFileResponse=new GetFileResponse();
        getFileResponse.fromResponseBody();
        System.out.println(getFileResponse.getBody());

    }*/

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




}
