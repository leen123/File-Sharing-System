package com.example.demo2.request;

import com.example.demo2.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class CheckInRequest extends RequestMap {
    @Getter
    @Setter
    private List<Integer> listFileId;
    public void fromRequest(Map<String, String> header, Map<String, ?> body) {
        super.fromRequest(header,body);
        token = header.get("token");
        listFileId=(List<Integer>) (body.get("listFileId"));
    }

}
