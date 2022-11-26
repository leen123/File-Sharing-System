package com.example.demo2.request;

import com.example.demo2.model.entity.User;

import java.util.List;
import java.util.Map;

public class CheckInRequest extends RequestMap {
    private List<String> listFileId;
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        listFileId=(List<String>) (body.get("listFileId"));
    }


    public List<String> getlistFileId() {
        return listFileId;
    }

    public void setlistFileId(List<String> listFileId) {
        this.listFileId = listFileId;
    }
}
