package com.example.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class GroupUser extends BaseEntity {
    private String stateUser;

    @ManyToOne(targetEntity = Groups.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id",referencedColumnName = "id", nullable = false,updatable = false)
    private Groups groups;
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false,updatable = false)
    private User user;

}