package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.UnitDAO;
import com.springboot.java_jangan.data.dto.unit.UnitDto;
import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;

import com.springboot.java_jangan.data.entity.Unit;
import com.springboot.java_jangan.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitDAO unitDAO;

    @Autowired
    public UnitServiceImpl(@Qualifier("unitDAOImpl") UnitDAO unitDAO){
        this.unitDAO = unitDAO;
    }


    @Override
    public List<Unit> getTotalUnit(UnitSearchDto unitSearchDto){
        return unitDAO.selectTotalUnit(unitSearchDto);
    }

    @Override
    public List<Unit> getUnit(UnitSearchDto unitSearchDto){
        return unitDAO.selectUnit(unitSearchDto);
    }
    @Override
    public Unit saveUnit(UnitDto unitDto) throws Exception {

        return unitDAO.insertUnit(unitDto);

    }
    @Override
    public Unit updateUnit(UnitDto unitDto) throws Exception {
        return unitDAO.updateUnit(unitDto);
    }
    @Override
    public void deleteUnit(List<Long> uid) throws Exception {
        unitDAO.deleteUnit(uid);
    }

}
