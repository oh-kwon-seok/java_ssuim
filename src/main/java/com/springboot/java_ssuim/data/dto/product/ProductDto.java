package com.springboot.java_ssuim.data.dto.product;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class ProductDto {
    private Long uid;
    private Integer sk_uid;

    private String ship_name;
    private String origin_name;
    private String inbox;
    private String outbox;
    private Integer qty;
    private Integer price;
    private Long used;
    private String token;

    public ProductDto(Long uid, Integer sk_uid, String ship_name, String origin_name, String inbox, String outbox, Integer qty, Integer price, Long used,String token
    ){
        this.uid = uid;
        this.sk_uid = sk_uid;
        this.ship_name = ship_name;
        this.origin_name = origin_name;
        this.inbox = inbox;
        this.outbox = outbox;
        this.qty = qty;
        this.used = used;
        this.price = price;
        this.token = token;

    }

}
