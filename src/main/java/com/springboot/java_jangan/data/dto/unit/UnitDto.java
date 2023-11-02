package com.springboot.java_jangan.data.dto.unit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitDto {
    private Long uid;
    private String name;
    private Long used;
    private String token;

    public UnitDto(Long uid, String name, Long used, String token){
        this.uid = uid;
        this.name = name;
        this.used = used;
        this.token = token;

    }

}
