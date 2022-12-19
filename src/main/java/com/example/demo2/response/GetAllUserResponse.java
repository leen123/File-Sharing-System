package com.example.demo2.response;

import com.example.demo2.dto.GroupUserDto;
import com.example.demo2.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GetAllUserResponse extends ResponseMap {
    @Setter
    @Getter
    private List<UserDto> listUser=new ArrayList<>();
    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("listUser",listUser);
    }

}

