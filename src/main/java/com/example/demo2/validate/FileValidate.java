package com.example.demo2.validate;

import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.resours.StateFile;
import com.example.demo2.repository.FileRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    public Map deleteFileValidate(DeleteFileRequest deleteFileRequest){
        Map valid = new HashMap();
        if(!fileRepository.existsById(deleteFileRequest.getFileId())){
            valid.put("status",412);
            valid.put("msg","this file not found");
        }else {
                valid.put("status",200);
                valid.put("msg","delete file succeeded");
        }


        return valid;
    }

    public Map getFileValidate(GetFileRequest getFileRequest){
        Map valid = new HashMap();
        if(!groupsRepository.existsById(getFileRequest.getGroupId())){
            valid.put("status",412);
            valid.put("msg","this group not found");
        }else {
            valid.put("status",200);
            valid.put("msg","fetch files succeeded");
        }


        return valid;
    }
    public Map getReportsFileValidate(GetReportsFileRequest getReportsFileRequest){
        Map valid = new HashMap();
        if(!fileRepository.existsById(getReportsFileRequest.getFileId())){
            valid.put("status",412);
            valid.put("msg","this file not found");
        }else {
            valid.put("status",200);
            valid.put("msg","fetch reports file succeeded");
        }
        return valid;
    }

    public Map checkInFilesValidate(int userId, List<Integer> fileIds){
        Map valid = new HashMap();
        valid.put("status",200);
        valid.put("msg","check in files succeeded");
        for (Integer fileId
                :fileIds ) {
            if(!fileRepository.existsById(fileId)){
                valid.put("status",412);
                valid.put("msg","some  file not found");

            }else{
                File file=fileRepository.findById(fileId).get();
                if(file.getState().contains(StateFile.checkIn.name())){
                    valid.put("status",412);
                    valid.put("msg","some  file already chickIn");
                }
            }
        }
        return valid;
    }
    public Map checkOutFilesValidate(int userId, List<Integer> fileIds){
        Map valid = new HashMap();
        valid.put("status",200);
        valid.put("msg","check out files succeeded");

        for (Integer fileId
                :fileIds ) {
            if(!fileRepository.existsById(fileId)){
                valid.put("status",412);
                valid.put("msg","some  file not found");

            }else{
                File file=fileRepository.findById(fileId).get();
                if(!file.getState().contains(StateFile.checkIn.name())){
                    valid.put("status",412);
                    valid.put("msg","some  file not chick in");
                }
            }
        }
        return valid;
    }



}
