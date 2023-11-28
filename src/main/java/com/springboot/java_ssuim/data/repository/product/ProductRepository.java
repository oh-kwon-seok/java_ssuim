package com.springboot.java_ssuim.data.repository.product;

import com.springboot.java_ssuim.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product,Long>, ProductRepositoryCustom {




}
