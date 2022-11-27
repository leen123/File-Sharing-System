package com.example.demo2.services;

import com.example.demo2.model.entity.*;
import com.example.demo2.repository.FileRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private GroupsService groupsService;
    @Autowired
    private ReportFilerService reportFilerService;

    public File getFile(int id){
        Optional<File> file = this.fileRepository.findById(id);
        return file.orElse(null);
    }
    public File saveFile(File file){
        return this.fileRepository.save(file);

    }
    public List<File> getAll(){
        return this.fileRepository.findAll();
    }
  /*  public List<File> getAllUser(GetFileRequest getFileRequest){
        User user= userService.getUser(Integer.parseInt(getFileRequest.token));
        List<File> fileList=groupUserService.getGroupByUser(user);

        return fileList;
    }*/
    public void delete(int id){
        this.fileRepository.deleteById(id);
    }
    public File createFile(CreateFileRequest createFileRequest){
        createFileRequest.getFile().setGroups(groupsService.getGroup(createFileRequest.getGroupId()));
        File file= this.fileRepository.save(createFileRequest.getFile());
         ReportFile reportFile = reportFilerService.saveReportFile(createFileRequest,file,"create");
        return file;
    }
}
