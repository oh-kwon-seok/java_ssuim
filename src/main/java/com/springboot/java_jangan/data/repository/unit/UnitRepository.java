package com.springboot.java_jangan.data.repository.unit;

import com.springboot.java_jangan.data.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("unitRepositorySupport")
public interface UnitRepository extends JpaRepository<Unit,Long>, UnitRepositoryCustom {

    Unit findByUid(Long uid);
}
