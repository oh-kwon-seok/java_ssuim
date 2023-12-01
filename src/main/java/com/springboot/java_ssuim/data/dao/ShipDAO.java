package com.springboot.java_ssuim.data.dao;

import com.springboot.java_ssuim.data.dto.ship.ShipDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Ship;

import java.util.List;


public interface ShipDAO {



    Ship insertShip(ShipDto shipDto) throws Exception;


    List<Ship> selectTotalShip(ShipSearchDto shipSearchDto);

    List<Ship> selectShip(ShipSearchDto shipSearchDto);

    Ship updateShip(ShipDto shipDto) throws Exception;

    String deleteShip(List<Long> uid) throws Exception;


}
