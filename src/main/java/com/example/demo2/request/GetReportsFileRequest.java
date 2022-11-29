package com.example.demo2.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class GetReportsFileRequest extends RequestMap {
    @Getter
    @Setter
    private int fileId;
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        fileId=(Integer)(body.get("fileId"));
    }

}
