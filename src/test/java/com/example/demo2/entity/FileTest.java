package com.example.demo2.entity;

import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.resours.StateFile;
import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class FileTest{

    public  static File fileTest1=File.builder()
            .name("")
            .size("12303")
            .state(StateFile.create.name())
            .groups(GroupsTest.groupsTest1)
            .build();
    public  static File fileTest2=File.builder()
            .name("")
            .size("12307")
            .state(StateFile.checkIn.name())
            .groups(GroupsTest.groupsTest1)
            .build();
    public  static File fileTest3=File.builder()
            .name("")
            .size("12304")
            .state(StateFile.checkIn.name())
            .groups(GroupsTest.groupsTest1)
            .build();
    public  static List listFileTest= Arrays.asList(fileTest1,fileTest2,fileTest3);

}
