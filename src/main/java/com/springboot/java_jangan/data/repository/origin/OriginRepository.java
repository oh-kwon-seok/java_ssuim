package com.springboot.java_jangan.data.repository.origin;

import com.springboot.java_jangan.data.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OriginRepositorySupport")
public interface OriginRepository extends JpaRepository<Origin,Long>, OriginRepositoryCustom {

    Origin findByUid(Long uid);
}
