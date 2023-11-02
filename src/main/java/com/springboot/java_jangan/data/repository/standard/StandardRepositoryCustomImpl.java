package com.springboot.java_jangan.data.repository.standard;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;
import com.springboot.java_jangan.data.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class StandardRepositoryCustomImpl extends QuerydslRepositorySupport implements StandardRepositoryCustom {

    public StandardRepositoryCustomImpl(){
        super(Standard.class);
    }

    @Override
    public List<Standard> findAll(StandardSearchDto standardSearchDto){
        QStandard standard = QStandard.standard;
        
        String filter_title = standardSearchDto.getFilter_title();
        String search_text = standardSearchDto.getSearch_text();

        LocalDateTime start_date = standardSearchDto.getStart_date();
        LocalDateTime end_date = standardSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (standard.name != null) {
                builder.or(standard.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(standard.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = standard.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = standard.used.eq(1);

        List<Standard> standardList = from(standard)
                .select(standard)
                .where(used,dateRange)
                .fetch();

        return standardList;
    }
    @Override
    public List<Standard> findInfo(StandardSearchDto StandardSearchDto){

        QStandard standard = QStandard.standard;

        Predicate used = standard.used.eq(1);

        List<Standard> standardList = from(standard)
                .select(standard)
                .where(used)
                .fetch();

        return standardList;
    }



}
