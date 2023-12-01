package com.springboot.java_ssuim.data.dto.ship;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShipResultDto {
    private boolean success;
    private int code;
    private String msg;

}
