package com.example.demo2.validate;

import com.example.demo2.model.entity.Groups;
import com.example.demo2.repository.FileRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.CreateFileRequest;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FileValidate {

    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private FileRepository fileRepository;
    public Map createFileValidate(CreateFileRequest createFileRequest){
        Map valid = new HashMap();
        if(!groupsRepository.existsById(createFileRequest.getGroupId())){
            valid.put("status",412);
            valid.put("msg","this group not found");
        }else {
            Groups groups=groupsRepository.getById(createFileRequest.getGroupId());

            if(fileRepository.existsByNameAndGroups(createFileRequest.getFile().getName(),groups)){
                valid.put("status",412);
                valid.put("msg","this name file already found");
            }
            else{
                valid.put("status",201);
                valid.put("msg","create file succeeded");
            }
        }


        return valid;
    }



}
