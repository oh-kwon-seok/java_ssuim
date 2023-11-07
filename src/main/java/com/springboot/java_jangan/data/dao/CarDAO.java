package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.car.CarDto;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.entity.Car;

import java.util.List;


public interface CarDAO {
    Car insertCar(CarDto carDto);

    List<Car> selectTotalCar(CarSearchDto CarSearchDto);
    List<Car> selectCar(CarSearchDto carSearchDto);

    Car updateCar(CarDto carDto) throws Exception;

    String deleteCar(List<Long> uid) throws Exception;


}
