package com.example.demo2.model.entity;

import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

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

    @Getter
    @Setter
    @Column( updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date updateFileAt=new Date(System.currentTimeMillis());
    @Column(nullable = false)
    private String name;
    private String url;
    private String size;
    @Column(nullable = false)
    @Where(clause = "state = 'MALE'")
    private String state;



    @ManyToOne(targetEntity = Groups.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "group_file_id",referencedColumnName = "id")
    private Groups groups;

}
