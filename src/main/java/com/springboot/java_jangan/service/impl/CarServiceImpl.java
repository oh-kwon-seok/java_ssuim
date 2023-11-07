package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.CarDAO;
import com.springboot.java_jangan.data.dto.car.CarDto;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.entity.Car;
import com.springboot.java_jangan.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDAO carDAO;

    @Autowired
    public CarServiceImpl(@Qualifier("carDAOImpl") CarDAO carDAO){
        this.carDAO = carDAO;
    }


    @Override
    public List<Car> getTotalCar(CarSearchDto carSearchDto){
        return carDAO.selectTotalCar(carSearchDto);
    }

    @Override
    public List<Car> getCar(CarSearchDto carSearchDto){
        return carDAO.selectCar(carSearchDto);
    }
    @Override
    public Car saveCar(CarDto carDto) throws Exception {

        return carDAO.insertCar(carDto);

    }
    @Override
    public Car updateCar(CarDto carDto) throws Exception {
        return carDAO.updateCar(carDto);
    }
    @Override
    public void deleteCar(List<Long> uid) throws Exception {
        carDAO.deleteCar(uid);
    }

}
