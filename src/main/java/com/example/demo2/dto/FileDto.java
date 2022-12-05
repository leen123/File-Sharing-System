package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.ReportFile;
import com.example.demo2.model.entity.User;
import com.example.demo2.repository.ReportFileRepository;
import com.example.demo2.services.ReportFilerService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FileDto extends BaseDto {
    protected Date updateFileAt=new Date(System.currentTimeMillis());
    private String name;
    private String url;
    private String size;
    private String state;
    private int groupId;
    private  ReportFileDto reportFileCreate=ReportFileDto.builder().build();
    private  ReportFileDto reportFileLast=ReportFileDto.builder().build();


    public void fromEntety(File file){

        super.fromEntety(file);
        id=file.getId();
        name=file.getName();
        url=file.getUrl();
        size=file.getSize();
        state=file.getState();
        updateFileAt=file.getUpdateFileAt();
        groupId=file.getGroups().getId();

         reportFileCreate=ReportFileDto.builder().build();
         reportFileLast=ReportFileDto.builder().build();

      //  reportFileDtoCreate.fromEntety(getCreateFile(file));
       // reportFileDtoLast.fromEntety(getTopFile(file));

    }

}
