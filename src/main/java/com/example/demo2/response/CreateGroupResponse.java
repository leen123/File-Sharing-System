package com.example.demo2.response;

import com.example.demo2.dto.GroupsDto;
import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.Groups;

public class CreateGroupResponse extends ResponseMap {
    GroupsDto groups=GroupsDto.builder().build();
    @Override
    public  void fromResponseBody() {
        //listFile=(List<File>) (body.get("listFile"));
        super.fromResponseBody();
        body.put("groups",groups);

    }

    public GroupsDto getGroups() {
        return groups;
    }

    public void setGroups(GroupsDto groups) {
        this.groups = groups;
    }

}

