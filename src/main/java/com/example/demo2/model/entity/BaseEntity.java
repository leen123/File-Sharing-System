package com.example.demo2.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class BaseEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Getter
    @Setter
    //@Column( nullable = false, updatable = false)
    @Column( updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdAt=new Date(System.currentTimeMillis());

/*
    @Getter
    @Setter
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    protected User createdBy;
*/

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date updatedAt=new Date(System.currentTimeMillis());

   /* @Getter
    @Setter
    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_user_id")
    protected User updatedBy;*/

}
