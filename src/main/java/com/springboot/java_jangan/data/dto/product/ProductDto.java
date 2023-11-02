package com.springboot.java_jangan.data.dto.product;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class ProductDto {
    private Long uid;

    private String name;
    private Long unit_uid;
    private Long standard_uid;
    private Long type_uid;
    private Long origin_uid;
    private Long used;
    private String token;

    public ProductDto(Long uid,String name,Long unit_uid, Long standard_uid,Long type_uid,Long origin_uid, Long used,String token){
        this.uid = uid;
        this.name = name;
        this.unit_uid = unit_uid;
        this.standard_uid = standard_uid;
        this.type_uid = type_uid;
        this.origin_uid = origin_uid;
        this.used = used;

        this.token = token;

    }

}
