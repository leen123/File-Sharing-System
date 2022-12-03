package com.example.demo2.response;

import com.example.demo2.dto.GroupsDto;
import com.example.demo2.model.entity.Groups;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Set;

import java.util.ArrayList;
import java.util.List;

public class GetGroupPublicResponse extends ResponseMap {
    @Getter
    @Setter
    private List<GroupsDto> listGroupPublic=new ArrayList<>();
    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("listGroupPublic",listGroupPublic);
    }


}


