package com.example.demo2.response;

import com.example.demo2.dto.FileDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GetFileSearchResponse extends ResponseMap {
    @Setter
    @Getter
    private List<FileDto> listFile=new ArrayList<>();
    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("listFile",listFile);
    }

}

