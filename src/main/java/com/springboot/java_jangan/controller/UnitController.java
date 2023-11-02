package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;

import com.springboot.java_jangan.data.dto.unit.UnitDto;
import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;

import com.springboot.java_jangan.data.entity.Unit;
import com.springboot.java_jangan.service.UnitService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/unit")
@Controller
public class UnitController {
    private final UnitService unitService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UnitController.class);

    @Autowired
    public UnitController(UnitService unitService){
        this.unitService = unitService;
    }

    @GetMapping(value= "/total_select")
    public ResponseEntity<List<Unit>> getTotalUnit(@ModelAttribute UnitSearchDto unitSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Unit> selectedTotalUnit = unitService.getTotalUnit(unitSearchDto);

        LOGGER.info("[getTotalUnit] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUnit);

    }
    @GetMapping(value= "/select")
    public ResponseEntity<List<Unit>> getUnit(@ModelAttribute UnitSearchDto unitSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Unit> selectedTotalUnit = unitService.getTotalUnit(unitSearchDto);

        LOGGER.info("[getTotalUnit] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUnit);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Unit> createUnit(@RequestBody UnitDto unitDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[unitDto]  : {}", unitDto);
        Unit insertUnit = unitService.saveUnit(unitDto);
        LOGGER.info("[createUnit] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertUnit);
    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Unit> updateUnit(@RequestBody UnitDto unitDto)
            throws Exception{

        Unit updateUnit = unitService.updateUnit(unitDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[unitDto]  : {}", unitDto);

        LOGGER.info("[updateUnit] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateUnit);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteUnit(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        unitService.deleteUnit(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
