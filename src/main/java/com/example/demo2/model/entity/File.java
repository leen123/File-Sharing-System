package com.example.demo2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class File extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String url;
    private String size;
    @Column(nullable = false)
    private String state;

    @ManyToOne(targetEntity = Groups.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "group_file_id",referencedColumnName = "id", nullable = false,updatable = false)
    private Groups groups;

//    @OneToMany(targetEntity = ReportFile.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "reports_file__id",referencedColumnName = "id",nullable = false)
//    private List<ReportFile> reportFiles;
}
