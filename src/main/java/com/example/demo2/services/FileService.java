package com.example.demo2.services;

import com.example.demo2.model.entity.*;
import com.example.demo2.model.entity.resours.StateFile;
import com.example.demo2.repository.FileRepository;
import com.example.demo2.repository.GroupsRepository;
import com.example.demo2.request.*;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
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
    private GroupsRepository groupsRepository;
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
    @Transactional
    public File createFile(CreateFileRequest createFileRequest){
        createFileRequest.getFile().setGroups(groupsRepository.findById(createFileRequest.getGroupId()).get());
        File file= this.fileRepository.save(createFileRequest.getFile());
         ReportFile reportFile = reportFilerService.saveReportFile(createFileRequest,file,"create");
        return file;
    }
    @Transactional
    public void deleteFile(int fileId)
    {
        this.reportFilerService.deleteByFile(fileId);
        File file =this.fileRepository.findById(fileId).get();
        file.setGroups(null);
        this.saveFile(file);
        this.fileRepository.deleteById(fileId);
    }
    @Transactional
    public void deleteFilesByGroup(int groupId)
    {
        Groups groups =this.groupsRepository.findById(groupId).get();
        List<File> fileList=fileRepository.findAllByGroups(groups).get();

        for (File file:fileList){
            deleteFile(file.getId());
        }
    }

    public List<File> getFileList(GetFileRequest getFileRequest){
        Groups groups =(groupsRepository.findById(getFileRequest.getGroupId()).get());
        List<File> fileList =fileRepository.findAllByGroups(groups).get();
        return fileList;
    }

    public boolean existsByState(String state){
        return fileRepository.existsByState(state);
    }

    @Transactional
    public File checkInFile(int userId,int fileId){
        File file =getFile(fileId);
        file.setState( StateFile.checkIn.name());
        file.setUpdatedAt( new Date(System.currentTimeMillis()));
        this.fileRepository.save(file);
        this.reportFilerService.createReportFile(userId,file, StateFile.checkIn.name());
        return file;
    }
    @Transactional
    public List<File> checkInFiles(int userId,List<Integer> fileIds){

        List<File> fileList=new ArrayList<>();
        for (Integer fileId
            :fileIds ) {
            fileList.add(this.checkInFile(userId,fileId));
        }
        return fileList;
    }
    @Transactional
    public File checkOutFile(int userId,int fileId){
        File file =getFile(fileId);
        file.setState( StateFile.checkOut.name());
        file.setUpdatedAt( new Date(System.currentTimeMillis()));
        this.fileRepository.save(file);
        this.reportFilerService.createReportFile(userId,file, StateFile.checkOut.name());
        return file;
    }
    @Transactional
    public List<File> checkOutFiles(int userId,List<Integer> fileIds){
        List<File> fileList=new ArrayList<>();
        for (Integer fileId
                :fileIds ) {
            fileList.add(this.checkOutFile(userId,fileId));
        }
        return fileList;
    }

}
