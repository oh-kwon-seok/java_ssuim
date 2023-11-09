package com.springboot.java_jangan.data.dto.user;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserDto {

    private String id;
    private String code;
    private String password;

    private String name;
    private String email;
    private String phone;

    private Long car_uid;

    private String auth;
    private Long used;
    private String token;

    public UserDto( String id,String code,String password,String name,String email,String phone, Long car_uid, String auth, Long used, String token){

        this.name = name;
        this.id = id;
        this.code = code;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.car_uid = car_uid;
        this.auth = auth;
        this.used = used;

        this.token = token;

    }

}
