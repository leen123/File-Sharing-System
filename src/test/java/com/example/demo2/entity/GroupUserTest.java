package com.example.demo2.entity;

import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.resours.TypeUserGroup;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Arrays;
import java.util.List;


public class GroupUserTest {
    public  static GroupUser groupUserTest1=GroupUser.builder()
            .stateUser(TypeUserGroup.owner.name())
            .user(UserTest.userTest1)
            .groups(GroupsTest.groupsTest1)
            .build();
    public  static GroupUser groupUserTest4=GroupUser.builder()
            .stateUser(TypeUserGroup.member.name())
            .user(UserTest.userTest2)
            .groups(GroupsTest.groupsTest1)
            .build();

    public  static  GroupUser groupUserTest2=GroupUser.builder()
            .stateUser(TypeUserGroup.owner.name())
            .user(UserTest.userTest2)
            .groups(GroupsTest.groupsTest2)
            .build();
    public  static GroupUser groupUserTest5=GroupUser.builder()
            .stateUser(TypeUserGroup.admin.name())
            .user(UserTest.userTest1)
            .groups(GroupsTest.groupsTest2)
            .build();
    public  static  GroupUser groupUserTest3=GroupUser.builder()
            .stateUser(TypeUserGroup.owner.name())
            .user(UserTest.userTest3)
            .groups(GroupsTest.groupsTest3)
            .build();
    public  static List listGroupUserTestTest= Arrays.asList(groupUserTest1,groupUserTest2,groupUserTest3,groupUserTest4,groupUserTest5);



}