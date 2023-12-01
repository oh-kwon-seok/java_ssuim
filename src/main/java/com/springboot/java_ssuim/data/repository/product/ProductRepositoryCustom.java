package com.springboot.java_ssuim.data.repository.product;

import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findAll(ProductSearchDto productSearchDto);

    List<Product> findInfo(ProductSearchDto productSearchDto);


}
