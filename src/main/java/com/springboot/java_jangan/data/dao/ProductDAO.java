package com.springboot.java_jangan.data.dao;

import com.springboot.java_jangan.data.dto.product.ProductDto;
import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.Product;

import java.util.List;


public interface ProductDAO {



    Product insertProduct(ProductDto productDto) throws Exception;


    List<Product> selectTotalProduct(ProductSearchDto productSearchDto);


    Product updateProduct(ProductDto productDto) throws Exception;

    String deleteProduct(List<Long> uid) throws Exception;


}
