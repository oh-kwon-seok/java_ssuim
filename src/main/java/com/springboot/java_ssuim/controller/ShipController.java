package com.springboot.java_ssuim.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.dto.ship.ShipDto;
import com.springboot.java_ssuim.data.dto.ship.ShipSearchDto;
import com.springboot.java_ssuim.data.entity.Ship;
import com.springboot.java_ssuim.data.entity.Ship;
import com.springboot.java_ssuim.service.ShipService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ship")
@Controller
public class ShipController {
    private final ShipService shipService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ShipController.class);

    @Autowired
    public ShipController(ShipService shipService){
        this.shipService = shipService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<Ship>> getTotalShip(@ModelAttribute ShipSearchDto shipSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Ship> selectedTotalShip = shipService.getTotalShip(shipSearchDto);

        LOGGER.info("[getTotalShip] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalShip);

    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Ship>> getShip(@ModelAttribute ShipSearchDto shipSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Ship> selectedTotalShip = shipService.getShip(shipSearchDto);

        LOGGER.info("[getTotalShip] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalShip);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ship> createShip(@RequestBody ShipDto shipDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[shipDto]  : {}", shipDto);
        Ship insertShip = shipService.saveShip(shipDto);
        LOGGER.info("[createShip] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertShip);




    }

    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ship> updateShip(@RequestBody ShipDto shipDto)
            throws Exception{

        Ship updateShip = shipService.updateShip(shipDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[shipDto]  : {}", shipDto);

        LOGGER.info("[updateShip] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateShip);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteShip(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        shipService.deleteShip(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
