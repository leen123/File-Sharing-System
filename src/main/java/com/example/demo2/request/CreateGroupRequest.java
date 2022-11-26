package com.example.demo2.request;

import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.Groups;

import java.util.Map;

public class CreateGroupRequest extends RequestMap {

    Groups group;
    @Override
    public void fromRequest(Map<String, String> header, Map<String,? > body) {
        token = header.get("token");
      //  groupid=(Integer)( body.get("groupid"));
        group= Groups.builder().build().fromMap((Map<String, ?>) body.get("group"));
    }

    public Groups getGroup() {
        return group;
    }


}
