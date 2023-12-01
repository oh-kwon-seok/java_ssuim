package com.springboot.java_ssuim.service;


import com.springboot.java_ssuim.data.dto.ship.ShipDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Ship;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipService {

    List<Ship> getTotalShip(ShipSearchDto shipSearchDto);

    List<Ship> getShip(ShipSearchDto shipSearchDto);

    Ship saveShip(ShipDto shipDto) throws Exception;

    Ship updateShip(ShipDto shipDto) throws Exception;

    void deleteShip(List<Long> uid) throws Exception;


}
