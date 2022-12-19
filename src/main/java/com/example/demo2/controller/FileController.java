
package com.example.demo2.controller;

import com.example.demo2.dto.FileDto;
import com.example.demo2.dto.ReportFileDto;
import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.ReportFile;
import com.example.demo2.model.entity.User;
import com.example.demo2.request.*;
import com.example.demo2.response.*;
import com.example.demo2.services.FileService;
import com.example.demo2.services.ReportFilerService;
import com.example.demo2.services.UserService;
import com.example.demo2.validate.FileValidate;
import com.example.demo2.validate.UserValidate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.ConfigurationException;
import javax.servlet.MultipartConfigElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private ReportFilerService reportFilerService;
   @Autowired
    private FileValidate fileValidate;




    @PostMapping(value = "/create_file")
    public ResponseEntity createFile(@RequestParam("fileobj") MultipartFile fileobj,@RequestParam("body")  String body , @RequestHeader Map<String,String> header) {
        System.out.println(body);
        CreateFileRequest createFileRequest= new CreateFileRequest();
        CreateFileResponse createFileResponse=new CreateFileResponse();
        createFileRequest.fromRequest(header,fileobj,body);

        Map response= fileValidate.createFileValidate(createFileRequest);
       // fileService.uploadFile(fileobj,createFileRequest.getFile());
       if((int)response.get("status")==201){
            File file =fileService.createFile(fileobj,createFileRequest);

            createFileResponse.getFileDto().fromEntety(file);
            createFileResponse.getFileDto().getReportFileCreate().fromEntety(reportFilerService.findFirstByFile(file));
            createFileResponse.getFileDto().getReportFileLast().fromEntety(reportFilerService.getLastReport(file));

            createFileResponse.fromResponseBody();
            response.put("body",createFileResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
    }

    @DeleteMapping("/delete_file")
    public ResponseEntity deleteFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        DeleteFileRequest deleteFileRequest= new DeleteFileRequest();
        DeleteFileResponse deleteFileResponse=new DeleteFileResponse();
        deleteFileRequest.fromRequest(header,body);

        Map response= fileValidate.deleteFileValidate(deleteFileRequest);
        if((int)response.get("status")==200){
            fileService.deleteFile(deleteFileRequest.getFileId());
            deleteFileResponse.fromResponseBody();
            response.put("body",deleteFileResponse.getBody());
        }
        return ResponseMap.responseEntity(response);

    }

    @PostMapping("/get_file_list_group")
    public ResponseEntity getFileListGroup(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetFileRequest getFileRequest= new GetFileRequest();
        GetFileResponse getFileResponse=new GetFileResponse();
        getFileRequest.fromRequest(header,body);

        Map response= fileValidate.getFileValidate(getFileRequest);
        if((int)response.get("status")==200){
            for(File file : fileService.getFileList(getFileRequest)){
               FileDto fileDto =FileDto.builder().groupId(getFileRequest.getGroupId()).build();
               fileDto.fromEntety(file);
                fileDto.getReportFileCreate().fromEntety(reportFilerService.findFirstByFile(file));
                fileDto.getReportFileLast().fromEntety(reportFilerService.getLastReport(file));

                getFileResponse.getListFile().add(fileDto);
            }
            getFileResponse.fromResponseBody();
            response.put("body",getFileResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        //System.out.println(response);
    }

    @PostMapping("/get_file_list_group_search")
    public ResponseEntity getFileListGroupSearch(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetFileSearchRequest getFileSearchRequest= new GetFileSearchRequest();
        GetFileSearchResponse getFileSearchResponse=new GetFileSearchResponse();
        getFileSearchRequest.fromRequest(header,body);

        Map response= fileValidate.getFileSearchValidate(getFileSearchRequest);
        if((int)response.get("status")==200){
            for(File file : fileService.getFileListSearch(getFileSearchRequest)){
                FileDto fileDto =FileDto.builder().groupId(getFileSearchRequest.getGroupId()).build();
                fileDto.fromEntety(file);
                fileDto.getReportFileCreate().fromEntety(reportFilerService.findFirstByFile(file));
                fileDto.getReportFileLast().fromEntety(reportFilerService.getLastReport(file));

                getFileSearchResponse.getListFile().add(fileDto);
            }
            getFileSearchResponse.fromResponseBody();
            response.put("body",getFileSearchResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
        //System.out.println(response);
    }
@PostMapping("/get_reports_file")
    public ResponseEntity getReportsFile(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        GetReportsFileRequest getReportsFileRequest= new GetReportsFileRequest();
        GetReportsResponse getReportsResponse=new GetReportsResponse();
    getReportsFileRequest.fromRequest(header,body);

        Map response= fileValidate.getReportsFileValidate(getReportsFileRequest);
        if((int)response.get("status")==200){
            for(ReportFile reportFile: reportFilerService.getReportFileList((getReportsFileRequest))){
                ReportFileDto reportFileDto =ReportFileDto.builder().build();
                reportFileDto.fromEntety(reportFile);
                getReportsResponse.getReportFileList().add(reportFileDto);
            }
            getReportsResponse.fromResponseBody();
            response.put("body",getReportsResponse.getBody());
        }
    return ResponseMap.responseEntity(response);
       // System.out.println(response);
    }

    @PostMapping("/chickIn_files")
    public ResponseEntity chickInFiles(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body)throws Exception{
        CheckInRequest checkInRequest= new CheckInRequest();
        CheckinResponse checkinResponse=new CheckinResponse();
        checkInRequest.fromRequest(header,body);

        Map response= fileValidate.checkInFilesValidate(Integer.parseInt(checkInRequest.token),checkInRequest.getListFileId());
        if((int)response.get("status")==200){
                fileService.checkInFiles(Integer.parseInt(checkInRequest.token),checkInRequest.getListFileId());
            checkinResponse.fromResponseBody();
            response.put("body",checkinResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
       // System.out.println(response);
    }
    @PostMapping("/chickOut_files")
    public ResponseEntity chickOutFiles(@RequestHeader Map<String,String> header, @RequestBody Map<String,?> body){
        CheckOutRequest checkOutRequest= new CheckOutRequest();
        CheckoutResponse checkOutResponse=new CheckoutResponse();
        checkOutRequest.fromRequest(header,body);
        List<Integer> fileIdList=new ArrayList<>();
        fileIdList.add(checkOutRequest.getFileId());
        Map response= fileValidate.checkOutFilesValidate(Integer.parseInt(checkOutRequest.token),fileIdList );
        if((int)response.get("status")==200){
            fileService.checkOutFiles(Integer.parseInt(checkOutRequest.token),fileIdList);
            checkOutResponse.fromResponseBody();
            response.put("body",checkOutResponse.getBody());
        }
        return ResponseMap.responseEntity(response);
      //  System.out.println(response);
    }





}
