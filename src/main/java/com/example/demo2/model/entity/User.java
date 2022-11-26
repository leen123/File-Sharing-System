package com.example.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;*/
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(unique = true,nullable = false)
    private  String email;
    @Column(nullable = false)
    private  String password;
   @Column(nullable = false)
    private  String typeUser;



  public static User demoBuilder(){
    return User.builder()
            .firstName("firstName")
            .lastName("lastName")
            .userName("userName")
            .email("email")
            .password("password")
            .typeUser("typeUser")
            .build();
   }
//   @CreatedBy
//    @OneToMany(targetEntity = GroupsDto.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_create_id",referencedColumnName = "id",nullable = false,updatable = false)
//    private List<GroupsDto> groupsList;

    /*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "groups_user" ,
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id"),},
    inverseJoinColumns = @JoinColumn(name = "group_id",referencedColumnName = "group_id")
    )
    private Set<GroupsDto> groupsSet=new HashSet<>();*/
/*
    @OneToMany(targetEntity = ReportFileDto.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "reports_file_user__id",referencedColumnName = "id",nullable = true)
    private List<ReportFileDto> reportFiles;

    @OneToMany (targetEntity = GroupUserDto.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private List<GroupUserDto> groupUsers;*/
}
