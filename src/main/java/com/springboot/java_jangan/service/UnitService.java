package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.unit.UnitDto;

import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;
import com.springboot.java_jangan.data.entity.Unit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitService {

    List<Unit> getTotalUnit(UnitSearchDto unitSearchDto);

    List<Unit> getUnit(UnitSearchDto unitSearchDto);


    Unit saveUnit(UnitDto unitDto) throws Exception;

    Unit updateUnit(UnitDto unitDto) throws Exception;

    void deleteUnit(List<Long> uid) throws Exception;


}
