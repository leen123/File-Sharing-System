package com.example.demo2.response;

import com.example.demo2.model.entity.User;

import java.util.List;

public class GetUserResponse extends ResponseMap {
    String token;
     User user;
  //  private List<String> listIdUser;
    @Override
    public  void fromResponseBody() {
      //  listIdUser=(List<String>) (body.get("listIdUser"));
        super.fromResponseBody();
        body.put("token",token);
        body.put("user",user);


    }


}
