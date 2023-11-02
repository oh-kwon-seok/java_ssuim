package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.UnitDAO;
import com.springboot.java_jangan.data.dto.unit.UnitDto;
import com.springboot.java_jangan.data.dto.unit.UnitSearchDto;
import com.springboot.java_jangan.data.entity.Unit;
import com.springboot.java_jangan.data.repository.unit.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UnitDAOImpl implements UnitDAO {
    
    private final UnitRepository unitRepository;
    @Autowired
    public UnitDAOImpl(UnitRepository unitRepository){
        this.unitRepository = unitRepository;

    }

    public Unit insertUnit(UnitDto unitDto) {



        Unit unit = new Unit();

        unit.setName(unitDto.getName());
        unit.setUsed(Math.toIntExact(unitDto.getUsed()));

        unit.setCreated(LocalDateTime.now());

        Unit insertUnit = unitRepository.save(unit);
        return insertUnit;

    }
    @Override
    public List<Unit> selectTotalUnit(UnitSearchDto unitSearchDto) {
        return unitRepository.findAll(unitSearchDto);

    }

    @Override
    public List<Unit> selectUnit(UnitSearchDto unitSearchDto) {
        return unitRepository.findInfo(unitSearchDto);

    }


    @Override
    public Unit updateUnit(UnitDto unitDto) throws Exception {


        Optional<Unit> selectedUnit = unitRepository.findById(unitDto.getUid());

        Unit updatedUnit;

        if (selectedUnit.isPresent()) {
            Unit unit = selectedUnit.get();
            unit.setName(unitDto.getName());
            unit.setUsed(Math.toIntExact(unitDto.getUsed()));

            unit.setUpdated(LocalDateTime.now());
            updatedUnit = unitRepository.save(unit);
        } else {
            throw new Exception();
        }
        return updatedUnit;
    }
    @Override
    public String deleteUnit(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Unit> selectedUnit = unitRepository.findById(uid);
            if (selectedUnit.isPresent()) {
                Unit unit = selectedUnit.get();
                unit.setUsed(0);
                unit.setDeleted(LocalDateTime.now());
                unitRepository.save(unit);
            } else {
                throw new Exception("Unit with UID " + uid + " not found.");
            }
        }
        return "Units deleted successfully";
    }
}
