package com.example.demo2.services;

import com.example.demo2.model.entity.*;
import com.example.demo2.repository.FileRepository;
import com.example.demo2.repository.GroupUserRepository;
import com.example.demo2.repository.ReportFileRepository;
import com.example.demo2.request.CreateFileRequest;
import com.example.demo2.request.CreateGroupRequest;
import com.example.demo2.request.GetGroupPrivateRequest;
import com.example.demo2.request.GetReportsFileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportFilerService {
    @Autowired
    private ReportFileRepository reportFileRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private FileRepository fileRepository;

    @Transactional
    public void deleteByFile(int fileId){
       List<ReportFile> reportFilesList=getReportFileListByFile(fileId);
       for(ReportFile reportFile:reportFilesList){
           reportFile.setFile(null);
       }
        this.reportFileRepository.saveAll(reportFilesList);


    }
    public List<ReportFile> getReportFileListByFile(int fileId){
        Optional<List<ReportFile>> reportFilesList = this.reportFileRepository.findAllByFile(
                fileRepository.getById(fileId)
        );
        return reportFilesList.orElse(null);
    }

    public List<ReportFile> getReportFileList(GetReportsFileRequest getReportsFileRequest){
        Optional<List<ReportFile>> reportFilesList = this.reportFileRepository.findAllByUserAndFile(
                userService.getUser(Integer.parseInt(getReportsFileRequest.token)),
                fileRepository.getById(getReportsFileRequest.getFileId())
        );
        return reportFilesList.orElse(null);
    }
    public ReportFile saveReportFile(CreateFileRequest createFileRequest, File file, String stateFile){
        User user= userService.getUser(Integer.parseInt(createFileRequest.token));
        ReportFile reportFile =reportFileRepository.save( ReportFile.builder().file(file).user(user).stateFile(stateFile).build());
        return reportFile;
    }

    public ReportFile createReportFile(int userID, File file, String stateFile){
        User user= userService.getUser(userID);
        ReportFile reportFile =reportFileRepository.save( ReportFile.builder().file(file).user(user).stateFile(stateFile).build());
        return reportFile;
    }

    public ReportFile findFirstByFile(File file){
        ReportFile reportFile =reportFileRepository.findFirstByFile( file).get();
        return reportFile;
    }
    public ReportFile getLastReport(File file){
       // ReportFile reportFile =reportFileRepository.findFirstByFileAndUpdatedAt(file,file.getUpdatedAt()).get();
        ReportFile reportFile =reportFileRepository.findFirstByFileOrderByCreatedAtDesc(file).get();
        return reportFile;
    }

}
