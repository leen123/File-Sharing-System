package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.ReportFile;
import com.example.demo2.model.entity.User;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReportFileDto extends BaseDto{
    private String stateFile;
    private int fileId;
    private int userId;
    public void fromEntety(ReportFile reportFile){
        super.fromEntety(reportFile);
        id=reportFile.getId();
        stateFile=reportFile.getStateFile();
        fileId=reportFile.getFile().getId();
        userId=reportFile.getUser().getId();
    }
}
