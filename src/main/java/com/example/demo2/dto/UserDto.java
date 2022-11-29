package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.User;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String userName;
    private  String email;
    private  String typeUser;

    public  void fromEntety(User user){
        super.fromEntety(user);
        id=user.getId();
       firstName=user.getFirstName();
       lastName=user.getLastName();
       userName=user.getUserName();
       email=user.getEmail();
       typeUser=user.getTypeUser();
    }
}
