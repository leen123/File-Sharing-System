package com.example.demo2.entity;


import com.example.demo2.model.entity.Groups;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;




public class GroupsTest {

 public  static Groups groupsTest1=Groups.builder()
         .name("group1")
         .typeGroup("private")
         .addUserAll(false)
         .editFilesAll(false)
         .editGroupAll(false)
         .user(UserTest.userTest1)
 .build();

 public  static  Groups groupsTest2=Groups.builder()
          .name("group2")
         .typeGroup("private")
         .addUserAll(true)
         .editFilesAll(true)
         .editGroupAll(true)
         .user(UserTest.userTest2)
         .build();
 public  static  Groups groupsTest3=Groups.builder()
         .name("group3")
         .typeGroup("public")
         .addUserAll(true)
         .editFilesAll(true)
         .editGroupAll(true)
         .user(UserTest.userTest3)
         .build();
 public  static List listGroupsTest= Arrays.asList(groupsTest1, groupsTest2,groupsTest3);

}