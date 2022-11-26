package com.example.demo2.dto;

import com.example.demo2.model.entity.BaseEntity;
import com.example.demo2.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private  String email;
    private  String typeUser;

    void fromUserEntety(User user){
       firstName=user.getFirstName();
       lastName=user.getLastName();
       userName=user.getUserName();
       email=user.getEmail();
       typeUser=user.getTypeUser();
    }
}
