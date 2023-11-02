package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.unit.UnitDto;
import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;
import com.springboot.java_jangan.data.entity.Unit;

import java.util.List;


public interface UnitDAO {
    Unit insertUnit(UnitDto unitDto);

    List<Unit> selectTotalUnit(UnitSearchDto UnitSearchDto);
    List<Unit> selectUnit(UnitSearchDto unitSearchDto);

    Unit updateUnit(UnitDto unitDto) throws Exception;

    String deleteUnit(List<Long> uid) throws Exception;


}
