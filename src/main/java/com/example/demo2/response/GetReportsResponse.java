package com.example.demo2.response;

import com.example.demo2.dto.ReportFileDto;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.ReportFile;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GetReportsResponse  extends ResponseMap {
    @Getter
    @Setter
    private List<ReportFileDto> reportFileList=new ArrayList<>();
    String token;
    @Override
    public  void fromResponseBody() {
        super.fromResponseBody();
        body.put("reportFileList",reportFileList);
    }}

