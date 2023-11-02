package com.springboot.java_jangan.data.repository.origin;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.entity.QOrigin;
import com.springboot.java_jangan.data.entity.Origin;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class OriginRepositoryCustomImpl extends QuerydslRepositorySupport implements OriginRepositoryCustom {

    public OriginRepositoryCustomImpl(){
        super(Origin.class);
    }

    @Override
    public List<Origin> findAll(OriginSearchDto originSearchDto){
        QOrigin origin = QOrigin.origin;

        String filter_title = originSearchDto.getFilter_title();
        String search_text = originSearchDto.getSearch_text();

        LocalDateTime start_date = originSearchDto.getStart_date();
        LocalDateTime end_date = originSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (origin.name != null) {
                builder.or(origin.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(origin.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = origin.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = origin.used.eq(1);

        List<Origin> originList = from(origin)
                .select(origin)
                .where(used,dateRange)
                .fetch();

        return originList;
    }
    @Override
    public List<Origin> findInfo(OriginSearchDto OriginSearchDto){

        QOrigin origin = QOrigin.origin;

        Predicate used = origin.used.eq(1);

        List<Origin> originList = from(origin)
                .select(origin)
                .where(used)
                .fetch();

        return originList;
    }



}
