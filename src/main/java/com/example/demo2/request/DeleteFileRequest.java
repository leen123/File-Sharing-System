package com.example.demo2.request;

import java.util.Map;

public class DeleteFileRequest extends RequestMap {
    private int fileId;
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        fileId=(Integer)(body.get("fileId"));
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
