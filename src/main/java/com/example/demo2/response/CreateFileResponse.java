package com.example.demo2.response;

import com.example.demo2.dto.FileDto;
import com.example.demo2.model.entity.File;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CreateFileResponse extends ResponseMap {
    @Getter
    @Setter
    FileDto fileDto=FileDto.builder().build();
    @Override
    public  void fromResponseBody() {
        //listFile=(List<File>) (body.get("listFile"));
        super.fromResponseBody();
        body.put("file",fileDto);

    }
}
