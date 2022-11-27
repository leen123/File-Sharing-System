package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FileDto extends BaseEntity {

    private String name;
    private String url;
    private String size;
    private String state;
    private int groupId;

    public void fromEntety(File file){
        id=file.getId();
        name=file.getName();
        url=file.getUrl();
        size=file.getSize();
        state=file.getState();
        groupId=file.getGroups().getId();
    }

}
