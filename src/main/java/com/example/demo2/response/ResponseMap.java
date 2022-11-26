package com.example.demo2.response;

import java.util.HashMap;
import java.util.Map;

public class ResponseMap {
    String status;
    String msg;
    Map body;
  public void fromResponseBody(){
      body=new HashMap();
  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map getBody() {
        return body;
    }

    public void setBody(Map body) {
        this.body = body;
    }
}
