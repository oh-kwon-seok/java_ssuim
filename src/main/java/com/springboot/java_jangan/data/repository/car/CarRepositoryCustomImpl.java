package com.springboot.java_jangan.data.repository.car;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.entity.QCar;
import com.springboot.java_jangan.data.entity.Car;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CarRepositoryCustomImpl extends QuerydslRepositorySupport implements CarRepositoryCustom {

    public CarRepositoryCustomImpl(){
        super(Car.class);
    }

    @Override
    public List<Car> findAll(CarSearchDto carSearchDto){
        QCar car = QCar.car;

        String filter_title = carSearchDto.getFilter_title();
        String search_text = carSearchDto.getSearch_text();

        LocalDateTime start_date = carSearchDto.getStart_date();
        LocalDateTime end_date = carSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (car.name != null) {
                builder.or(car.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(car.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = car.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = car.used.eq(1);

        List<Car> carList = from(car)
                .select(car)
                .where(used,dateRange)
                .fetch();

        return carList;
    }
    @Override
    public List<Car> findInfo(CarSearchDto CarSearchDto){

        QCar car = QCar.car;

        Predicate used = car.used.eq(1);

        List<Car> carList = from(car)
                .select(car)
                .where(used)
                .fetch();

        return carList;
    }




}
