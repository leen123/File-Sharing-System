package com.example.demo2.services;

import com.example.demo2.model.entity.*;
import com.example.demo2.model.entity.resours.StateFile;
import com.example.demo2.repository.FileRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    public void deleteFile(DeleteFileRequest deleteFileRequest)
    {
        this.reportFilerService.deleteByFile(Integer.parseInt(deleteFileRequest.token));
        File file =this.fileRepository.findById(Integer.parseInt(deleteFileRequest.token)).get();
        file.setGroups(null);
        this.saveFile(file);
        this.fileRepository.deleteById(Integer.parseInt(deleteFileRequest.token));
    }
    public List<File> getFileList(GetFileRequest getFileRequest){
        Groups groups =(groupsService.getGroup(getFileRequest.getGroupId()));
        List<File> fileList =fileRepository.findAllByGroups(groups).get();
        return fileList;
    }

    public boolean existsByState(String state){
        return fileRepository.existsByState(state);
    }

    public File checkInFile(int userId,int fileId){
        File file =getFile(fileId);
        file.setState( StateFile.checkIn.name());
        file.setUpdatedAt( new Date(System.currentTimeMillis()));
        this.fileRepository.save(file);
        this.reportFilerService.createReportFile(userId,file, StateFile.checkIn.name());
        return file;
    }

    public List<File> checkInFiles(int userId,List<Integer> fileIds){
        List<File> fileList=new ArrayList<>();
        for (Integer fileId
            :fileIds ) {
            fileList.add(this.checkInFile(userId,fileId));
        }
        return fileList;
    }

    public File checkOutFile(int userId,int fileId){
        File file =getFile(fileId);
        file.setState( StateFile.checkOut.name());
        file.setUpdatedAt( new Date(System.currentTimeMillis()));
        this.fileRepository.save(file);
        this.reportFilerService.createReportFile(userId,file, StateFile.checkOut.name());
        return file;
    }
    public List<File> checkOutFiles(int userId,List<Integer> fileIds){
        List<File> fileList=new ArrayList<>();
        for (Integer fileId
                :fileIds ) {
            fileList.add(this.checkOutFile(userId,fileId));
        }
        return fileList;
    }

}
