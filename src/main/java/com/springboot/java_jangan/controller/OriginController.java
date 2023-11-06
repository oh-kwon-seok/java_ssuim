package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.origin.OriginDto;

import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.entity.Origin;
import com.springboot.java_jangan.service.OriginService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/origin")
@Controller
public class OriginController {
    private final OriginService originService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(OriginController.class);

    @Autowired
    public OriginController(OriginService originService){
        this.originService = originService;
    }
    @GetMapping(value= "/select")
    public ResponseEntity<List<Origin>> getTotalOrigin(@ModelAttribute OriginSearchDto originSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Origin> selectedTotalOrigin = originService.getTotalOrigin(originSearchDto);

        LOGGER.info("[getTotalOrigin] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalOrigin);

    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Origin>> getOrigin(@ModelAttribute OriginSearchDto originSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Origin> selectedTotalOrigin = originService.getOrigin(originSearchDto);

        LOGGER.info("[getTotalOrigin] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalOrigin);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Origin> createOrigin(@RequestBody OriginDto originDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[originDto]  : {}", originDto);
        Origin insertOrigin = originService.saveOrigin(originDto);
        LOGGER.info("[createOrigin] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertOrigin);
    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Origin> updateOrigin(@RequestBody OriginDto originDto)
            throws Exception{

        Origin updateOrigin = originService.updateOrigin(originDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[originDto]  : {}", originDto);

        LOGGER.info("[updateOrigin] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateOrigin);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteOrigin(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        originService.deleteOrigin(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
