package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.CarDAO;
import com.springboot.java_jangan.data.dto.car.CarDto;
import com.springboot.java_jangan.data.dto.car.CarSearchDto;
import com.springboot.java_jangan.data.entity.Car;
import com.springboot.java_jangan.data.repository.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CarDAOImpl implements CarDAO {
    
    private final CarRepository carRepository;
    @Autowired
    public CarDAOImpl(CarRepository carRepository){
        this.carRepository = carRepository;

    }

    public Car insertCar(CarDto carDto) {



        Car car = new Car();

        car.setName(carDto.getName());
        car.setUsed(Math.toIntExact(carDto.getUsed()));

        car.setCreated(LocalDateTime.now());

        Car insertCar = carRepository.save(car);
        return insertCar;

    }
    @Override
    public List<Car> selectTotalCar(CarSearchDto carSearchDto) {
        return carRepository.findAll(carSearchDto);

    }

    @Override
    public List<Car> selectCar(CarSearchDto carSearchDto) {
        return carRepository.findInfo(carSearchDto);

    }


    @Override
    public Car updateCar(CarDto carDto) throws Exception {


        Optional<Car> selectedCar = carRepository.findById(carDto.getUid());

        Car updatedCar;

        if (selectedCar.isPresent()) {
            Car car = selectedCar.get();
            car.setName(carDto.getName());
            car.setUsed(Math.toIntExact(carDto.getUsed()));

            car.setUpdated(LocalDateTime.now());
            updatedCar = carRepository.save(car);
        } else {
            throw new Exception();
        }
        return updatedCar;
    }
    @Override
    public String deleteCar(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Car> selectedCar = carRepository.findById(uid);
            if (selectedCar.isPresent()) {
                Car car = selectedCar.get();
                car.setUsed(0);
                car.setDeleted(LocalDateTime.now());
                carRepository.save(car);
            } else {
                throw new Exception("Car with UID " + uid + " not found.");
            }
        }
        return "Cars deleted successfully";
    }
}
