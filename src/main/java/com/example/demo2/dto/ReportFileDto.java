package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.ReportFile;
import com.example.demo2.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ReportFileDto extends BaseEntity{
    private String stateFile;
    private int fileId;
    private int userId;
    void fromEntety(ReportFile reportFile){
        id=reportFile.getId();
        stateFile=reportFile.getStateFile();
        fileId=reportFile.getFile().getId();
        userId=reportFile.getUser().getId();
    }
}
