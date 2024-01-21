package com.springboot.java_ssuim.data.repository.standard;

import com.springboot.java_ssuim.data.entity.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("standardRepositorySupport")
public interface StandardRepository extends JpaRepository<Standard,Long>, StandardRepositoryCustom {




}
