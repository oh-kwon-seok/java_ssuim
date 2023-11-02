package com.springboot.java_jangan.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ChangeProductNameDto {
    private Long uid;
    private String name;

    public ChangeProductNameDto(Long uid,String name){
        this.uid = uid;
        this.name = name;

    }
    public ChangeProductNameDto(){

    }



}
