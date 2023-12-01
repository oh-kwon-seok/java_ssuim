package com.springboot.java_ssuim.service.impl;

import com.springboot.java_ssuim.data.dao.ShipDAO;
import com.springboot.java_ssuim.data.dto.ship.ShipDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Ship;
import com.springboot.java_ssuim.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipDAO shipDAO;

    @Autowired
    public ShipServiceImpl(@Qualifier("shipDAOImpl") ShipDAO shipDAO){
        this.shipDAO = shipDAO;
    }


    @Override
    public List<Ship> getTotalShip(ShipSearchDto shipSearchDto){
        return shipDAO.selectTotalShip(shipSearchDto);
    }
    @Override
    public List<Ship> getShip(ShipSearchDto shipSearchDto){
        return shipDAO.selectShip(shipSearchDto);
    }

    @Override
    public Ship saveShip(ShipDto shipDto) throws Exception {

        return shipDAO.insertShip(shipDto);

    }
    @Override
    public Ship updateShip(ShipDto shipDto) throws Exception {
        return shipDAO.updateShip(shipDto);
    }
    @Override
    public void deleteShip(List<Long> uid) throws Exception {
        shipDAO.deleteShip(uid);
    }

}
