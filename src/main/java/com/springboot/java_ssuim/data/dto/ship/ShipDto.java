package com.springboot.java_ssuim.data.dto.ship;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class ShipDto {
    private Long uid;

    private String area;
    private String receive_user;
    private String phone1;
    private String phone2;
    private String address;
    private String token;
    private Long used;


    public ShipDto(Long uid, String area, String receive_user, String phone1,String phone2, String address,  Long used, String token
    ){
        this.uid = uid;
        this.area = area;
        this.receive_user = receive_user;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.used = used;
        this.token = token;

    }

}
