package com.example.demo2.request;

import java.util.Map;

public class GetFileRequest extends RequestMap {
    private int groupid;
    @Override
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        token = header.get("token");
        groupid=(Integer)body.get("groupid");
    }


    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }
}