package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.standard.StandardDto;
import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;

import com.springboot.java_jangan.data.entity.Standard;
import com.springboot.java_jangan.service.StandardService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/standard")
@Controller
public class StandardController {
    private final StandardService standardService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(StandardController.class);

    @Autowired
    public StandardController(StandardService standardService){
        this.standardService = standardService;
    }
    @GetMapping(value= "/select")
    public ResponseEntity<List<Standard>> getTotalStandard(@ModelAttribute StandardSearchDto standardSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Standard> selectedTotalStandard = standardService.getTotalStandard(standardSearchDto);

        LOGGER.info("[getTotalStandard] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalStandard);

    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Standard>> getStandard(@ModelAttribute StandardSearchDto standardSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Standard> selectedTotalStandard = standardService.getStandard(standardSearchDto);

        LOGGER.info("[getTotalStandard] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalStandard);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Standard> createStandard(@RequestBody StandardDto standardDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[standardDto]  : {}", standardDto);
        Standard insertStandard = standardService.saveStandard(standardDto);
        LOGGER.info("[createStandard] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertStandard);
    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Standard> updateStandard(@RequestBody StandardDto standardDto)
            throws Exception{

        Standard updateStandard = standardService.updateStandard(standardDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[standardDto]  : {}", standardDto);

        LOGGER.info("[updateStandard] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateStandard);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteStandard(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        standardService.deleteStandard(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
