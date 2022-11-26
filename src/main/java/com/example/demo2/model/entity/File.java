package com.example.demo2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class File extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String url;
    private String size;
    @Column(nullable = false)
    private String state;
    private Date dateEdit;
    private Date date;
    public File fromMap(Map<String,?> map){
       return File.builder()
                .name((String) map.get("name"))
                .url((String) map.get("url"))
                .size((String) map.get("size"))
                .state((String) map.get("state"))
                .build();
    }
//    @OneToMany(targetEntity = ReportFile.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "reports_file__id",referencedColumnName = "id",nullable = false)
//    private List<ReportFile> reportFiles;

    @ManyToOne(targetEntity = Groups.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "group_file_id",referencedColumnName = "id", nullable = false,updatable = false)
    private Groups groups;

//    @OneToMany(targetEntity = ReportFile.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "reports_file__id",referencedColumnName = "id",nullable = false)
//    private List<ReportFile> reportFiles;
}
