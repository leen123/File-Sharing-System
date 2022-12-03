package com.example.demo2.model.entity;

import lombok.*;
import org.hibernate.annotations.Where;

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
    @Where(clause = "state = 'MALE'")
    private String state;
    public File fromMap(Map<String,?> map){
       return File.builder()
                .name((String) map.get("name"))
                .url((String) map.get("url"))
                .size((String) map.get("size"))
                .state((String) map.get("state"))
                .build();
    }
//    @OneToMany(targetEntity = ReportFileDto.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "reports_file__id",referencedColumnName = "id",nullable = false)
//    private List<ReportFileDto> reportFiles;

    @ManyToOne(targetEntity = Groups.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "group_file_id",referencedColumnName = "id")
    private Groups groups;

//    @OneToMany(targetEntity = ReportFileDto.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "reports_file__id",referencedColumnName = "id",nullable = false)
//    private List<ReportFileDto> reportFiles;
}
