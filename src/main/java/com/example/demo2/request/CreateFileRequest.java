package com.example.demo2.request;

import com.example.demo2.model.entity.File;

import java.util.Map;

public class CreateFileRequest extends RequestMap {
    private int groupId;
    File file=File.builder().build();
    //private Integer fileId;
    @Override
    public void fromRequest(Map<String, String> header, Map<String,? > body) {
        token = header.get("token");
        groupId=(Integer)( body.get("groupId"));
       file=File.builder().build().fromMap((Map<String, ?>) body.get("file"));
    }

    public int getGroupId() {
        return groupId;
    }

    public File getFile() {
        return file;
    }
}
