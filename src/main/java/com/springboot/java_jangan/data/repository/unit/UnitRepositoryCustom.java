package com.springboot.java_jangan.data.repository.unit;
import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;
import com.springboot.java_jangan.data.entity.Unit;
import java.util.List;

public interface UnitRepositoryCustom {
    List<Unit> findAll(UnitSearchDto unitSearchDto);
    List<Unit> findInfo(UnitSearchDto unitSearchDto);

}
