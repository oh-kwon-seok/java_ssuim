package com.springboot.java_ssuim.data.repository.ship;

import com.springboot.java_ssuim.data.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("shipRepositorySupport")
public interface ShipRepository extends JpaRepository<Ship,Long>, ShipRepositoryCustom {




}
