package com.example.demo2.dto;


import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.ReportFile;
import com.example.demo2.model.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GroupsDto extends BaseDto{


    private String name;
    private Boolean editFilesAll;
    private Boolean addUserAll;
    private Boolean editGroupAll;
    private String typeGroup;
    private int userCreateId;
    public  void fromEntety(Groups groups){
        super.fromEntety(groups);
        id=groups.getId();
        name =groups.getName();
        editFilesAll=groups.getEditFilesAll();
        addUserAll=groups.getAddUserAll();
        editGroupAll=groups.getEditGroupAll();
        typeGroup =groups.getTypeGroup();
        userCreateId =groups.getUser().getId();
    }

}