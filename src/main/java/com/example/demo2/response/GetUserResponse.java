package com.example.demo2.response;

import com.example.demo2.dto.UserDto;
import com.example.demo2.model.entity.User;

import java.util.List;

public class GetUserResponse extends ResponseMap {
    String token;
    UserDto userDto=UserDto.builder().build();
  //  private List<String> listIdUser;
    @Override
    public  void fromResponseBody() {
      //  listIdUser=(List<String>) (body.get("listIdUser"));
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
