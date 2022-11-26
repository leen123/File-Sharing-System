package com.example.demo2.request;


import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.util.Map;

public interface RequestMap {
    public  String token="";
    void fromRequest(Map<String,String> header,Map<String,String> body);
}
