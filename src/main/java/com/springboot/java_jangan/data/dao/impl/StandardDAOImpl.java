package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.StandardDAO;
import com.springboot.java_jangan.data.dto.standard.StandardDto;
import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;
import com.springboot.java_jangan.data.entity.Standard;
import com.springboot.java_jangan.data.repository.standard.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StandardDAOImpl implements StandardDAO {

    private final StandardRepository standardRepository;
    @Autowired
    public StandardDAOImpl(StandardRepository standardRepository){
        this.standardRepository = standardRepository;

    }

    public Standard insertStandard(StandardDto standardDto) {



        Standard standard = new Standard();

        standard.setName(standardDto.getName());
        standard.setUsed(Math.toIntExact(standardDto.getUsed()));

        standard.setCreated(LocalDateTime.now());

        Standard insertStandard = standardRepository.save(standard);
        return insertStandard;

    }
    @Override
    public List<Standard> selectTotalStandard(StandardSearchDto standardSearchDto) {
        return standardRepository.findAll(standardSearchDto);

    }

    @Override
    public List<Standard> selectStandard(StandardSearchDto standardSearchDto) {
        return standardRepository.findInfo(standardSearchDto);

    }


    @Override
    public Standard updateStandard(StandardDto standardDto) throws Exception {


        Optional<Standard> selectedStandard = standardRepository.findById(standardDto.getUid());

        Standard updatedStandard;

        if (selectedStandard.isPresent()) {
            Standard standard = selectedStandard.get();
            standard.setName(standardDto.getName());
            standard.setUsed(Math.toIntExact(standardDto.getUsed()));

            standard.setUpdated(LocalDateTime.now());
            updatedStandard = standardRepository.save(standard);
        } else {
            throw new Exception();
        }
        return updatedStandard;
    }
    @Override
    public String deleteStandard(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Standard> selectedStandard = standardRepository.findById(uid);
            if (selectedStandard.isPresent()) {
                Standard standard = selectedStandard.get();
                standard.setUsed(0);
                standard.setDeleted(LocalDateTime.now());
                standardRepository.save(standard);
            } else {
                throw new Exception("Standard with UID " + uid + " not found.");
            }
        }
        return "Standards deleted successfully";
    }
}
