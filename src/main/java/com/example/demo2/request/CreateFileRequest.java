package com.example.demo2.request;

import com.example.demo2.model.entity.File;

import java.util.Map;

public class CreateFileRequest extends RequestMap {
    private int groupid;
    File file;
    //private Integer fileId;
    @Override
    public void fromRequest(Map<String, String> header, Map<String,? > body) {
        token = header.get("token");
        groupid=(Integer)( body.get("groupid"));
       file=File.builder().build().fromMap((Map<String, ?>) body.get("file"));
    }

    public int getGroupid() {
        return groupid;
    }

    public File getFile() {
        return file;
    }
}
