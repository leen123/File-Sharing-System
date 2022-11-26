package com.example.demo2.request;

import java.util.List;
import java.util.Map;

public class CheckOutRequest extends RequestMap {
    private String fileId;
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        fileId=(String) (body.get("fileId"));
    }


    public String getfileId() {
        return fileId;
    }

    public void setfileId(String fileId) {
        this.fileId = fileId;
    }
}
