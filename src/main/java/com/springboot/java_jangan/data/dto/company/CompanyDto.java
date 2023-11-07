package com.springboot.java_jangan.data.dto.company;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString

public class CompanyDto {
    private Long uid;
    private String code;
    private String name;
    private String phone;
    private String email;

    private Long used;
    private String token;

    public CompanyDto(Long uid,String code,String name,String phone, String email,Long used, String token){
        this.uid = uid;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;

        this.used = used;
        this.token = token;

    }

}
