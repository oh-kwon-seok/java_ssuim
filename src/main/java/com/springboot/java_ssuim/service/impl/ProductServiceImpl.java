package com.springboot.java_ssuim.service.impl;

import com.springboot.java_ssuim.data.dao.ProductDAO;
import com.springboot.java_ssuim.data.dto.product.ProductDto;
import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.entity.Product;
import com.springboot.java_ssuim.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(@Qualifier("productDAOImpl") ProductDAO productDAO){
        this.productDAO = productDAO;
    }


    @Override
    public List<Product> getTotalProduct(ProductSearchDto productSearchDto){
        return productDAO.selectTotalProduct(productSearchDto);
    }

    @Override
    public List<Product> getProduct(ProductSearchDto productSearchDto){
        return productDAO.selectProduct(productSearchDto);
    }
    
    @Override
    public Product saveProduct(ProductDto productDto) throws Exception {

        return productDAO.insertProduct(productDto);

    }
    @Override
    public Product updateProduct(ProductDto productDto) throws Exception {
        return productDAO.updateProduct(productDto);
    }
    @Override
    public void deleteProduct(List<Long> uid) throws Exception {
        productDAO.deleteProduct(uid);
    }

}
