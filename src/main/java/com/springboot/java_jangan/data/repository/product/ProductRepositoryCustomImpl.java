package com.springboot.java_jangan.data.repository.product;

import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;

import com.springboot.java_jangan.data.dto.product.ProductSearchDto;
import com.springboot.java_jangan.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl(){
        super(Product.class);
    }
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);

    @Override
    public List<Product> findAll(ProductSearchDto productSearchDto){
        QProduct product = QProduct.product;
        QUnit unit = QUnit.unit;
        QStandard standard = QStandard.standard;
        QOrigin origin = QOrigin.origin;
        QType type = QType.type;


        String filter_title = productSearchDto.getFilter_title();
        String search_text = productSearchDto.getSearch_text();

        LocalDateTime start_date = productSearchDto.getStart_date();
        LocalDateTime end_date = productSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (product.name != null) {
               builder.or(product.name.like("%" + search_text + "%"));
            }
            if (product.unit != null) {
                builder.or(unit.name.like("%" + search_text + "%"));
            }
            if (product.type != null) {
                builder.or(type.name.like("%" + search_text + "%"));
            }
            if (product.origin != null) {
                builder.or(origin.name.like("%" + search_text + "%"));
            }
            if (product.standard != null) {
                builder.or(standard.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(product.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(type.name.like("%" + search_text + "%"));
            }
            else if("unit".equals(filter_title)){
                builder.and(unit.name.like("%" + search_text + "%"));
            }
            else if("origin".equals(filter_title)){
                builder.and(origin.name.like("%" + search_text + "%"));
            }
            else if("standard".equals(filter_title)){
                builder.and(standard.name.like("%" + search_text + "%"));
            }

        }
        Predicate dateRange = product.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = product.used.eq(1);
        Predicate predicate = builder.getValue();


        List<Tuple> results = from(product)
                .leftJoin(product.unit, unit)
                .leftJoin(product.standard, standard).fetchJoin() // Left join standard
                .leftJoin(product.origin, origin).fetchJoin() // Left join origin
                .leftJoin(product.type, type).fetchJoin() // Left join type
                .select(product, unit, standard, origin, type)
                .where(predicate,dateRange,used)
                .orderBy(product.created.desc()) // Order by created field in descending order
                .fetch();
        List<Product> productList = new ArrayList<>();

        for (Tuple result : results) {
            Product productEntity = result.get(product);
            productList.add(productEntity);
            LOGGER.info("[Entity] data: {}", productEntity);
        }

        return productList;
    }


}
