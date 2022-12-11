package com.example.demo2.model.entity.resours;

import com.example.demo2.model.entity.BaseEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Logging extends BaseEntity {

    @Getter
    @Setter
    private String method;
    @Getter
    @Setter
    private String  requestUri;
    @Getter
    @Setter
    private String  requestPayload;
    @Getter
    @Setter
    private int  responseCode;
    @Getter
    @Setter
    private String   response;
    @Getter
    @Setter
    private long   timeTaken ;


}
