package com.springboot.java_ssuim.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_ssuim.data.dto.standard.StandardDto;
import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.entity.Standard;
import com.springboot.java_ssuim.service.StandardService;
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

    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Standard>> getStandard(@ModelAttribute StandardSearchDto standardSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Standard> selectedTotalStandard = standardService.getStandard(standardSearchDto);

        LOGGER.info("[getTotalStandard] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalStandard);

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

}
