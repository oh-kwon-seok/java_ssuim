package com.springboot.java_ssuim.data.dto.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductSearchDto {

    private LocalDateTime start_date;
    private String search_text;
    private String filter_title;
    private LocalDateTime end_date;
}
