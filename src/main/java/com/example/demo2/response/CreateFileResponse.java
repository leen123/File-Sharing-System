package com.example.demo2.response;

import com.example.demo2.model.entity.File;

import java.util.List;

public class CreateFileResponse extends ResponseMap {
    String token;
    File file;
    @Override
    public  void fromResponseBody() {
        //listFile=(List<File>) (body.get("listFile"));
        super.fromResponseBody();
        body.put("token",token);
        body.put("file",file);

    }
}
