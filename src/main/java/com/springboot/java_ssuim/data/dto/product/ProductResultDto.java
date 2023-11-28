package com.springboot.java_ssuim.data.dto.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResultDto {
    private boolean success;
    private int code;
    private String msg;

}
