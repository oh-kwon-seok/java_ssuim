package com.springboot.java_ssuim.data.repository.ship;

import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Ship;

import java.util.List;

public interface ShipRepositoryCustom {
    List<Ship> findAll(ShipSearchDto shipSearchDto);
    List<Ship> findInfo(ShipSearchDto shipSearchDto);


}
