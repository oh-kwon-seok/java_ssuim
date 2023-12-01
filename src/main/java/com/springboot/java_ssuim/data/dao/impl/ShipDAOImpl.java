package com.springboot.java_ssuim.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_ssuim.data.dao.ShipDAO;
import com.springboot.java_ssuim.data.dto.ship.ShipDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Ship;
import com.springboot.java_ssuim.data.repository.ship.ShipRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ShipDAOImpl implements ShipDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ShipDAOImpl.class);

    private final ShipRepository shipRepository;



    @Autowired
    public ShipDAOImpl(ShipRepository shipRepository

    ) {
        this.shipRepository = shipRepository;

    }

    @Override
    public Ship insertShip(ShipDto shipDto) throws Exception {



        Ship ship = new Ship();

        ship.setArea(shipDto.getArea());
        ship.setReceive_user(shipDto.getReceive_user());
        ship.setPhone1(shipDto.getPhone1());
        ship.setPhone2(shipDto.getPhone2());
        ship.setAddress(shipDto.getAddress());

        ship.setUsed(1);

        LOGGER.info("[ship : ]: {}", ship);


        Ship insertShip = shipRepository.save(ship);
        return insertShip;

    }

    @Override
    public List<Ship> selectTotalShip(ShipSearchDto shipSearchDto) {
        return shipRepository.findAll(shipSearchDto);

    }
    @Override
    public List<Ship> selectShip(ShipSearchDto shipSearchDto) {
        return shipRepository.findInfo(shipSearchDto);

    }
    @Override
    public Ship updateShip(ShipDto shipDto) throws Exception {

        Optional<Ship> selectedShip = shipRepository.findById(shipDto.getUid());

        Ship updatedShip;

        if (selectedShip.isPresent()) {
            Ship ship = selectedShip.get();

            ship.setArea(shipDto.getArea());
            ship.setReceive_user(shipDto.getReceive_user());
            ship.setPhone1(shipDto.getPhone1());
            ship.setPhone2(shipDto.getPhone2());
            ship.setAddress(shipDto.getAddress());
            ship.setUsed(1);

            updatedShip = shipRepository.save(ship);
        } else {
            throw new Exception();
        }
        return updatedShip;
    }

    @Override
    public String deleteShip(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Ship> selectedShip = shipRepository.findById(uid);
            if (selectedShip.isPresent()) {
                Ship ship = selectedShip.get();
                ship.setUsed(0);
                ship.setDeleted(LocalDateTime.now());
                shipRepository.save(ship);
            } else {
                throw new Exception("Ship with UID " + uid + " not found.");
            }
        }
        return "Ships deleted successfully";
    }
}