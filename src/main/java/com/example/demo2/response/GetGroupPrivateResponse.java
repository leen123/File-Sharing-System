package com.example.demo2.response;

import com.example.demo2.dto.GroupsDto;
import com.example.demo2.model.entity.Groups;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GetGroupPrivateResponse extends ResponseMap {
    @Getter
    @Setter
    private List<GroupsDto> listGroupPrivate=new ArrayList<>();
    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("listGroupPrivate",listGroupPrivate);
}}
