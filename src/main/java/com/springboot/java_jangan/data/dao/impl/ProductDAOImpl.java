package com.springboot.java_jangan.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dao.ProductDAO;
import com.springboot.java_jangan.data.dto.product.ProductDto;
import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.*;
import com.springboot.java_jangan.data.repository.origin.OriginRepository;
import com.springboot.java_jangan.data.repository.product.ProductRepository;
import com.springboot.java_jangan.data.repository.standard.StandardRepository;
import com.springboot.java_jangan.data.repository.type.TypeRepository;
import com.springboot.java_jangan.data.repository.unit.UnitRepository;
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
    private final UnitRepository unitRepository;
    private final StandardRepository standardRepository;
    private final OriginRepository originRepository;
    private final TypeRepository typeRepository;


    @Autowired
    public ProductDAOImpl(ProductRepository productRepository,
                          UnitRepository unitRepository,
                          StandardRepository standardRepository,
                          OriginRepository originRepository,
                          TypeRepository typeRepository
    ) {
        this.productRepository = productRepository;
        this.unitRepository = unitRepository;
        this.standardRepository = standardRepository;
        this.originRepository = originRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public Product insertProduct(ProductDto productDto) throws Exception {

        Unit unit = unitRepository.findByUid(Long.valueOf(productDto.getUnit_uid()));
        Standard standard = standardRepository.findByUid(Long.valueOf(productDto.getStandard_uid()));
        Origin origin = originRepository.findByUid(Long.valueOf(productDto.getOrigin_uid()));
        Type type = typeRepository.findByUid(Long.valueOf(productDto.getType_uid()));

        Product product = new Product();

        product.setName(productDto.getName());
        product.setUsed(Math.toIntExact(productDto.getUsed()));
        product.setUnit(unit);
        product.setStandard(standard);
        product.setOrigin(origin);
        product.setType(type);
        product.setCreated(LocalDateTime.now());


        LOGGER.info("[product : ]: {}", product);


        Product insertProduct = productRepository.save(product);
        return insertProduct;

    }

    @Override
    public List<Product> selectTotalProduct(ProductSearchDto productSearchDto) {
        return productRepository.findAll(productSearchDto);

    }

    @Override
    public Product updateProduct(ProductDto productDto) throws Exception {

        Unit unit = unitRepository.findByUid(Long.valueOf(productDto.getUnit_uid()));
        Standard standard = standardRepository.findByUid(Long.valueOf(productDto.getStandard_uid()));
        Origin origin = originRepository.findByUid(Long.valueOf(productDto.getOrigin_uid()));
        Type type = typeRepository.findByUid(Long.valueOf(productDto.getType_uid()));
        Optional<Product> selectedProduct = productRepository.findById(productDto.getUid());

        Product updatedProduct;

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(productDto.getName());
            product.setUsed(Math.toIntExact(productDto.getUsed()));
            product.setUnit(unit);
            product.setStandard(standard);
            product.setOrigin(origin);
            product.setType(type);
            product.setUpdated(LocalDateTime.now());
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