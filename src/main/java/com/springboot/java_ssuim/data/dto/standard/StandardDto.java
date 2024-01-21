package com.springboot.java_ssuim.data.dto.standard;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class StandardDto {
    private Long uid;

    private Integer milkrun_qty;
    private Integer order_limit_qty;




    public StandardDto(Long uid, Integer milkrun_qty,Integer order_limit_qty){
        this.uid = uid;
        this.milkrun_qty = milkrun_qty;
        this.order_limit_qty = order_limit_qty;


    }

}
