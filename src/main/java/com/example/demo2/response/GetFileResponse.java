package com.example.demo2.response;

import com.example.demo2.model.entity.File;

import java.util.List;

public class GetFileResponse extends ResponseMap {
    private List<File> listFile;
    String token;
    @Override
    public  void fromResponseBody() {
        listFile=(List<File>) (body.get("listFile"));
        super.fromResponseBody();
        body.put("token",token);
    }}

