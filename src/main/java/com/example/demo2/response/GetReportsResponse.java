package com.example.demo2.response;

import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.ReportFile;

import java.util.List;

public class GetReportsResponse  extends ResponseMap {
    private List<ReportFile> listGroupPublic;
    String token;
    @Override
    public  void fromResponseBody() {
        listGroupPublic=(List<ReportFile>) (body.get("listGroupPublic"));
        super.fromResponseBody();
        body.put("token",token);
    }}

