package com.springboot.java_ssuim.data.repository.product;

import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_ssuim.controller.ProductController;

import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.entity.*;
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

        String filter_title = productSearchDto.getFilter_title();
        String search_text = productSearchDto.getSearch_text();

        LocalDateTime start_date = productSearchDto.getStart_date();
        LocalDateTime end_date = productSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (product.sk_uid != null) {
                builder.or(product.sk_uid.like("%" + search_text + "%"));
            }
            if (product.ship_name != null) {
                builder.or(product.ship_name.like("%" + search_text + "%"));
            }
            if (product.origin_name != null) {
                builder.or(product.origin_name.like("%" + search_text + "%"));
            }
            if (product.inbox != null) {
                builder.or(product.inbox.like("%" + search_text + "%"));
            }
            if (product.outbox != null) {
                builder.or(product.outbox.like("%" + search_text + "%"));
            }

        }else {
            if("sk_uid".equals(filter_title)){
                builder.and(product.sk_uid.like("%" + search_text + "%"));
            }
            else if("ship_name".equals(filter_title)){
                builder.and(product.ship_name.like("%" + search_text + "%"));
            }
            else if("origin_name".equals(filter_title)){
                builder.and(product.origin_name.like("%" + search_text + "%"));
            }
            else if("inbox".equals(filter_title)){
                builder.and(product.inbox.like("%" + search_text + "%"));
            }
            else if("outbox".equals(filter_title)){
                builder.and(product.outbox.like("%" + search_text + "%"));
            }

        }

        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = product.used.eq(1);
        Predicate predicate = builder.getValue();


        List<Product> productList = from(product)
                .select(product)
                .where(predicate,used)
                .orderBy(product.origin_name.desc()) // Order by created field in descending order
                .fetch();


        return productList;
    }


}