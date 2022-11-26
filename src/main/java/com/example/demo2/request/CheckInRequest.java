package com.example.demo2.request;

import com.example.demo2.model.entity.User;

import java.util.List;
import java.util.Map;

public class CheckInRequest extends RequestMap {
    private List<String> listIdFile;


    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        listIdFile=(List<String>) (body.get("listIdFile"));
    }


    public List<String> getListIdFile() {
        return listIdFile;
    }

    public void setListIdFile(List<String> listIdFile) {
        this.listIdFile = listIdFile;
    }
}
