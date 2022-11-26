package com.example.demo2.response;

import com.example.demo2.model.entity.Groups;

import java.util.List;

public class GetGroupPrivateResponse extends ResponseMap {
    private List<Groups> listGroupPrivate;
    String token;
    @Override
    public  void fromResponseBody() {
        listGroupPrivate=(List<Groups>) (body.get("listGroupPrivate"));
        super.fromResponseBody();
        body.put("token",token);
}}
