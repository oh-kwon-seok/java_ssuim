package com.springboot.java_ssuim.service;


import com.springboot.java_ssuim.data.dto.product.ProductDto;

import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getTotalProduct(ProductSearchDto productSearchDto);

    List<Product> getProduct(ProductSearchDto productSearchDto);

    Product saveProduct(ProductDto productDto) throws Exception;

    Product updateProduct(ProductDto productDto) throws Exception;

    void deleteProduct(List<Long> uid) throws Exception;


}
