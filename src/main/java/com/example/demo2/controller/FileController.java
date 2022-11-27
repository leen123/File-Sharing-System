
package com.example.demo2.controller;

import com.example.demo2.model.entity.User;
import com.example.demo2.request.*;
import com.example.demo2.response.*;
import com.example.demo2.services.FileService;
import com.example.demo2.services.UserService;
import com.example.demo2.validate.FileValidate;
import com.example.demo2.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
   @Autowired
    private FileValidate fileValidate;


    @PostMapping("/create_file")
    public void createFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CreateFileRequest createFileRequest= new CreateFileRequest();
        CreateFileResponse createFileResponse=new CreateFileResponse();
        createFileRequest.fromRequest(header,body);

        Map response= fileValidate.createFileValidate(createFileRequest);
        if((int)response.get("status")==201){
            createFileResponse.getFileDto().fromEntety(fileService.createFile(createFileRequest));
            createFileResponse.fromResponseBody();
            response.put("body",createFileResponse.getBody());
        }
        System.out.println(response);
    }


}
