package com.springboot.java_jangan.data.dto.car;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString



public class CarDto {
    private Long uid;
    private String name;
    private Long used;
    private String token;

    public CarDto(Long uid, String name, Long used, String token){
        this.uid = uid;
        this.name = name;
        this.used = used;
        this.token = token;

    }

}
