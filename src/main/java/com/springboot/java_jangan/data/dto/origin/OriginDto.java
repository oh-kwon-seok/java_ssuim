package com.springboot.java_jangan.data.dto.origin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OriginDto {
    private Long uid;
    private String name;
    private Long used;
    private String token;

    public OriginDto(Long uid,String name, Long used,String token){
        this.uid = uid;
        this.name = name;
        this.used = used;
        this.token = token;

    }

}
