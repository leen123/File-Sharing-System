package com.example.demo2.response;

import com.example.demo2.dto.FileDto;
import com.example.demo2.dto.GroupUserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GetUserGroupResponse extends ResponseMap {
    @Setter
    @Getter
    private List<GroupUserDto> listGroupUser=new ArrayList<>();
    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("listGroupUser",listGroupUser);
    }

}

