package com.example.demo2.entity;

import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.ReportFile;
import com.example.demo2.model.entity.resours.StateFile;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Arrays;
import java.util.List;

public class ReportFileTest {
    public  static ReportFile reportFileTest1=ReportFile.builder()
            .stateFile(StateFile.create.name())
            .file(FileTest.fileTest1)
            .user(UserTest.userTest1)
            .build();
    public  static ReportFile reportFileTest2=ReportFile.builder()
            .stateFile(StateFile.create.name())
            .file(FileTest.fileTest2)
            .user(UserTest.userTest1)
            .build();
    public  static ReportFile reportFileTest3=ReportFile.builder()
            .stateFile(StateFile.checkIn.name())
            .file(FileTest.fileTest2)
            .user(UserTest.userTest1)
            .build();
    public  static ReportFile reportFileTest4=ReportFile.builder()
            .stateFile(StateFile.create.name())
            .file(FileTest.fileTest3)
            .user(UserTest.userTest2)
            .build();
    public  static ReportFile reportFileTest5=ReportFile.builder()
            .stateFile(StateFile.checkIn.name())
            .file(FileTest.fileTest3)
            .user(UserTest.userTest2)
            .build();
    public  static List listReportFileTest= Arrays.asList(reportFileTest1,reportFileTest2,reportFileTest3,reportFileTest4,reportFileTest5);
}
