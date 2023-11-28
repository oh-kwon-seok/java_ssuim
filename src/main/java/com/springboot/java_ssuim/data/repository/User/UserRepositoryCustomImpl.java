package com.springboot.java_ssuim.data.repository.User;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_ssuim.controller.ProductController;
import com.springboot.java_ssuim.data.dto.user.UserSearchDto;

import com.springboot.java_ssuim.data.entity.User;
import com.springboot.java_ssuim.data.entity.QUser;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryCustomImpl(){
        super(User.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);

    @Override
    public List<User> findAll(UserSearchDto userSearchDto){
        QUser user = QUser.user;



        String filter_title = userSearchDto.getFilter_title();
        String search_text = userSearchDto.getSearch_text();

        LocalDateTime start_date = userSearchDto.getStart_date();
        LocalDateTime end_date = userSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (user.id != null) {
                builder.or(user.id.like("%" + search_text + "%"));
            }
            if (user.name != null) {
                builder.or(user.name.like("%" + search_text + "%"));
            }
            if (user.phone != null) {
                builder.or(user.phone.like("%" + search_text + "%"));
            }if (user.email != null) {
                builder.or(user.email.like("%" + search_text + "%"));
            }



        }else {
            if("id".equals(filter_title)){
                builder.and(user.id.like("%" + search_text + "%"));
            }

            else if("name".equals(filter_title)){
                builder.and(user.name.like("%" + search_text + "%"));
            }
            else if("phone".equals(filter_title)){
                builder.and(user.phone.like("%" + search_text + "%"));
            }
            else if("email".equals(filter_title)){
                builder.and(user.email.like("%" + search_text + "%"));
            }


        }
        Predicate dateRange = user.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = user.used.eq(1);

//        Predicate auth = user.auth.contains("ROLE_ADMIN");

        Predicate predicate = builder.getValue();


        List<User> userList = from(user)
                .select(user)
                .where(predicate,used,dateRange)
                .orderBy(user.id.desc()) // Order by created field in descending order
                .fetch();

        return userList;

    }
    @Override
    public List<User> findInfo(UserSearchDto UserSearchDto){

        QUser user = QUser.user;

        Predicate used = user.used.eq(1);

        List<User> userList = from(user)
                .select(user)
                .where(used)
                .fetch();

        return userList;
    }




}
