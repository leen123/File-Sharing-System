package com.example.demo2.response;

import com.example.demo2.dto.UserDto;
import com.example.demo2.model.entity.User;

public class RegisterResponse extends ResponseMap{
    String token;
    UserDto userDto=UserDto.builder().build();

    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("token",token);
        body.put("user",userDto);
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
