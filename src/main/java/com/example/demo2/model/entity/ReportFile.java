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
public class ReportFile extends BaseEntity{
    private String stateFile;

    @ManyToOne(targetEntity = File.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id",referencedColumnName = "id", nullable = false,updatable = false)
    private File file;
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false,updatable = false)
    private User user;

//    @ManyToMany(mappedBy = "groupsSet")
  //  private Set<User> userSet =new HashSet<>();
}
