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

    public List<ReportFile> getReportFileList(GetReportsFileRequest getReportsFileRequest){
        Optional<List<ReportFile>> reportFilesList = this.reportFileRepository.findAllByUserAndAndFile(
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

}
