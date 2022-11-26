package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.GroupUser;
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
public class GroupUserDto extends BaseEntity {
    private String stateUser;
    private int groupId;
    private int userId;
    void fromEntety(GroupUser groupUser){
        id=groupUser.getId();
        stateUser=groupUser.getStateUser();
        groupId=groupUser.getGroups().getId();
        userId=groupUser.getUser().getId();
    }

}