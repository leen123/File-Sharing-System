package com.example.demo2.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@ToString
public class BaseDto {
    @Getter
    public int id;
    @Getter
    @Setter
    protected Date createdAt=new Date(System.currentTimeMillis());
    @Getter
    @Setter
    protected Date updatedAt=new Date(System.currentTimeMillis());
}
