package com.springboot.java_jangan.data.repository.standard;

import com.springboot.java_jangan.data.entity.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("StandardRepositorySupport")
public interface StandardRepository extends JpaRepository<Standard,Long>, StandardRepositoryCustom {

    Standard findByUid(Long uid);
}
