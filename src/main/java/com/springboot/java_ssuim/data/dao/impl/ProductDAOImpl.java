package com.springboot.java_ssuim.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_ssuim.data.dao.ProductDAO;
import com.springboot.java_ssuim.data.dto.product.ProductDto;
import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.entity.*;

import com.springboot.java_ssuim.data.repository.product.ProductRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductDAOImpl.class);

    private final ProductRepository productRepository;



    @Autowired
    public ProductDAOImpl(ProductRepository productRepository

    ) {
        this.productRepository = productRepository;

    }

    @Override
    public Product insertProduct(ProductDto productDto) throws Exception {



        Product product = new Product();
        product.setSk_uid(productDto.getSk_uid());

        product.setShip_name(productDto.getShip_name());
        product.setOrigin_name(productDto.getOrigin_name());
        product.setInbox(productDto.getInbox());
        product.setOutbox(productDto.getInbox());
        product.setQty(productDto.getQty());
        product.setPrice(productDto.getPrice());
        product.setUsed(1);

        LOGGER.info("[product : ]: {}", product);


        Product insertProduct = productRepository.save(product);
        return insertProduct;

    }

    @Override
    public List<Product> selectTotalProduct(ProductSearchDto productSearchDto) {
        return productRepository.findAll(productSearchDto);

    }
    @Override
    public List<Product> selectProduct(ProductSearchDto productSearchDto) {
        return productRepository.findInfo(productSearchDto);

    }

    @Override
    public Product updateProduct(ProductDto productDto) throws Exception {

        Optional<Product> selectedProduct = productRepository.findById(productDto.getUid());

        Product updatedProduct;

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setSk_uid(productDto.getSk_uid());
            product.setShip_name(productDto.getShip_name());
            product.setOrigin_name(productDto.getOrigin_name());
            product.setInbox(productDto.getInbox());
            product.setOutbox(productDto.getInbox());
            product.setQty(productDto.getQty());
            product.setPrice(productDto.getPrice());
            product.setUsed(1);

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public String deleteProduct(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Product> selectedProduct = productRepository.findById(uid);
            if (selectedProduct.isPresent()) {
                Product product = selectedProduct.get();
                product.setUsed(0);
                product.setDeleted(LocalDateTime.now());
                productRepository.save(product);
            } else {
                throw new Exception("Product with UID " + uid + " not found.");
            }
        }
        return "Products deleted successfully";
    }
}