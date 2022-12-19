package com.example.demo2.entity;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class UserTest {

 public  static  User userTest1=User.builder().
         firstName("firstName1").
 lastName("lastName1").
 userName("userName1").
 email("email1@gmail.com").
 typeUser("user").password("123456").build();

 public  static  User userTest2=User.builder().
         firstName("firstName2").
         lastName("lastName2").
         userName("userName2").
         email("email2@gmail.com").
         typeUser("user").password("123456").build();
 public  static  User userTest3=User.builder().
         firstName("firstName3").
         lastName("lastName3").
         userName("userName3").
         email("email3@gmail.com").
         typeUser("admin").password("123456").build();
 public  static List listUserTest= Arrays.asList(userTest1, userTest2,userTest3);


}
