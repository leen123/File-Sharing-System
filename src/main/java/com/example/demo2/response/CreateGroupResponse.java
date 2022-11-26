package com.example.demo2.response;

import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.Groups;

public class CreateGroupResponse extends ResponseMap {
    Groups groups;
    String token;
    @Override
    public  void fromResponseBody() {
        //listFile=(List<File>) (body.get("listFile"));
        super.fromResponseBody();
        body.put("token",token);
        body.put("groups",groups);

    }
}

