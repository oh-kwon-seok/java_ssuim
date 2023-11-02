package com.springboot.java_jangan.data.repository.unit;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;
import com.springboot.java_jangan.data.entity.QUnit;
import com.springboot.java_jangan.data.entity.Unit;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class UnitRepositoryCustomImpl extends QuerydslRepositorySupport implements UnitRepositoryCustom {

    public UnitRepositoryCustomImpl(){
        super(Unit.class);
    }

    @Override
    public List<Unit> findAll(UnitSearchDto unitSearchDto){
        QUnit unit = QUnit.unit;

        String filter_title = unitSearchDto.getFilter_title();
        String search_text = unitSearchDto.getSearch_text();

        LocalDateTime start_date = unitSearchDto.getStart_date();
        LocalDateTime end_date = unitSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (unit.name != null) {
                builder.or(unit.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(unit.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = unit.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = unit.used.eq(1);

        List<Unit> unitList = from(unit)
                .select(unit)
                .where(used,dateRange)
                .fetch();

        return unitList;
    }
    @Override
    public List<Unit> findInfo(UnitSearchDto UnitSearchDto){

        QUnit unit = QUnit.unit;

        Predicate used = unit.used.eq(1);

        List<Unit> unitList = from(unit)
                .select(unit)
                .where(used)
                .fetch();

        return unitList;
    }




}
