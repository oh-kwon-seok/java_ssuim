package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.car.CarDto;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.entity.Car;
import com.springboot.java_jangan.service.CarService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
@Controller
public class CarController {
    private final CarService carService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(CarController.class);

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<Car>> getTotalCar(@ModelAttribute CarSearchDto carSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Car> selectedTotalCar = carService.getTotalCar(carSearchDto);

        LOGGER.info("[getTotalCar] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalCar);

    }
    @GetMapping(value= "/info_select")
    public ResponseEntity<List<Car>> getCar(@ModelAttribute CarSearchDto carSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Car> selectedTotalCar = carService.getCar(carSearchDto);

        LOGGER.info("[getTotalCar] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalCar);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> createCar(@RequestBody CarDto carDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[carDto]  : {}", carDto);
        Car insertCar = carService.saveCar(carDto);
        LOGGER.info("[createCar] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(insertCar);
    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> updateCar(@RequestBody CarDto carDto)
            throws Exception{

        Car updateCar = carService.updateCar(carDto);
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[carDto]  : {}", carDto);

        LOGGER.info("[updateCar] response Time : {}ms", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(updateCar);
    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteCar(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        carService.deleteCar(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
