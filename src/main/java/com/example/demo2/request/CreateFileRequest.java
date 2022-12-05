package com.example.demo2.request;

import com.example.demo2.model.entity.File;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CreateFileRequest extends RequestMap {
    private int groupId;
    File file=File.builder().build();
    //private Integer fileId;

    public void fromRequest(Map<String, String> header,MultipartFile fileobj, String body) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            CreateFileRequest modelDTO = mapper.readValue(body, CreateFileRequest.class);
           groupId=modelDTO.getGroupId();
           file=modelDTO.getFile();
            file.setName(fileobj.getOriginalFilename());
            try {
                file.setSize(""+fileobj.getBytes().length);
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        token = header.get("token");

    }

    public int getGroupId() {
        return groupId;
    }

    public File getFile() {
        return file;
    }
}
