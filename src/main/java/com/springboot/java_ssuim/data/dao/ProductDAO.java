package com.springboot.java_ssuim.data.dao;

import com.springboot.java_ssuim.data.dto.product.ProductDto;
import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.entity.Product;

import java.util.List;


public interface ProductDAO {



    Product insertProduct(ProductDto productDto) throws Exception;


    List<Product> selectTotalProduct(ProductSearchDto productSearchDto);

    List<Product> selectProduct(ProductSearchDto productSearchDto);


    Product updateProduct(ProductDto productDto) throws Exception;

    String deleteProduct(List<Long> uid) throws Exception;


}
