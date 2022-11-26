package com.example.demo2.response;

import com.example.demo2.model.entity.Groups;

import java.util.List;

public class GetGroupPublicResponse extends ResponseMap {
    private List<Groups> listGroupPublic;
    String token;
    @Override
    public  void fromResponseBody() {
        listGroupPublic=(List<Groups>) (body.get("listGroupPublic"));
        super.fromResponseBody();
        body.put("token",token);
    }}


