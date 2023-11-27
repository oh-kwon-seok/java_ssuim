package com.springboot.java_jangan.data.repository.UserProduct;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.controller.ProductController;
import com.springboot.java_jangan.data.dto.user.UserSearchDto;
import com.springboot.java_jangan.data.entity.QCar;
import com.springboot.java_jangan.data.entity.QUser;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.entity.UserProduct;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserProductRepositoryCustomImpl extends QuerydslRepositorySupport implements UserProductRepositoryCustom {

    public UserProductRepositoryCustomImpl(){
        super(UserProduct.class);
    }







}
