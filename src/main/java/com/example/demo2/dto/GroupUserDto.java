package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.GroupUser;
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
public class GroupUserDto extends BaseDto{
    private String stateUser;
    private int groupId;
    private int userId;
    private UserDto user=UserDto.builder().build();
    public  void fromEntety(GroupUser groupUser){
        super.fromEntety(groupUser);
        id=groupUser.getId();
        stateUser=groupUser.getStateUser();
        groupId=groupUser.getGroups().getId();
        userId=groupUser.getUser().getId();

        user=UserDto.builder().build();
        user.fromEntety(groupUser.getUser());
    }

}