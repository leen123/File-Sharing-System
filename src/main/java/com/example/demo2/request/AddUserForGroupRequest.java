package com.example.demo2.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class AddUserForGroupRequest extends RequestMap {
    @Setter
    @Getter
    private int groupId;
    @Setter
    @Getter
    private int userId;

    @Override
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        groupId=(Integer)body.get("groupId");
        userId=(Integer)body.get("userId");
    }

}