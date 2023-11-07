package com.springboot.java_jangan.data.repository.car;

import com.springboot.java_jangan.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("carRepositorySupport")
public interface CarRepository extends JpaRepository<Car,Long>, CarRepositoryCustom {

    Car findByUid(Long uid);
}
