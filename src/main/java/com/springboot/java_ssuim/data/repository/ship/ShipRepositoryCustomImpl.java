package com.springboot.java_ssuim.data.repository.ship;

import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_ssuim.controller.ShipController;
import com.springboot.java_ssuim.data.dto.product.ProductSearchDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Product;
import com.springboot.java_ssuim.data.entity.QProduct;
import com.springboot.java_ssuim.data.entity.Ship;
import com.springboot.java_ssuim.data.entity.QShip;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ShipRepositoryCustomImpl extends QuerydslRepositorySupport implements ShipRepositoryCustom {

    public ShipRepositoryCustomImpl(){
        super(Ship.class);
    }
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ShipController.class);

    @Override
    public List<Ship> findAll(ShipSearchDto shipSearchDto){
        QShip ship = QShip.ship;

        String filter_title = shipSearchDto.getFilter_title();
        String search_text = shipSearchDto.getSearch_text();

        LocalDateTime start_date = shipSearchDto.getStart_date();
        LocalDateTime end_date = shipSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (ship.area != null) {
                builder.or(ship.area.like("%" + search_text + "%"));
            }
            if (ship.receive_user != null) {
                builder.or(ship.receive_user.like("%" + search_text + "%"));
            }
            if (ship.phone1 != null) {
                builder.or(ship.phone1.like("%" + search_text + "%"));
            }
            if (ship.phone2 != null) {
                builder.or(ship.phone2.like("%" + search_text + "%"));
            }
            if (ship.address != null) {
                builder.or(ship.address.like("%" + search_text + "%"));
            }

        }else {
            if("area".equals(filter_title)){
                builder.and(ship.area.like("%" + search_text + "%"));
            }
            else if("receive_user".equals(filter_title)){
                builder.and(ship.receive_user.like("%" + search_text + "%"));
            }
            else if("phone1".equals(filter_title)){
                builder.and(ship.phone1.like("%" + search_text + "%"));
            }
            else if("phone2".equals(filter_title)){
                builder.and(ship.phone2.like("%" + search_text + "%"));
            }
            else if("address".equals(filter_title)){
                builder.and(ship.address.like("%" + search_text + "%"));
            }

        }

        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = ship.used.eq(1);
        Predicate predicate = builder.getValue();


        List<Ship> shipList = from(ship)
                .select(ship)
                .where(predicate,used)
                .orderBy(ship.area.desc()) // Order by created field in descending order
                .fetch();


        return shipList;
    }

    @Override
    public List<Ship> findInfo(ShipSearchDto ShipSearchDto){

        QShip ship = QShip.ship;

        Predicate used = ship.used.eq(1);

        List<Ship> shipList = from(ship)
                .select(ship)
                .where(used)
                .fetch();

        return shipList;
    }


}