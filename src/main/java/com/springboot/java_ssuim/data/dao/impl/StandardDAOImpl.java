package com.springboot.java_ssuim.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_ssuim.data.dao.StandardDAO;
import com.springboot.java_ssuim.data.dto.standard.StandardDto;
import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.entity.Standard;
import com.springboot.java_ssuim.data.repository.standard.StandardRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StandardDAOImpl implements StandardDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(StandardDAOImpl.class);

    private final StandardRepository standardRepository;



    @Autowired
    public StandardDAOImpl(StandardRepository standardRepository

    ) {
        this.standardRepository = standardRepository;

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

            standard.setMilkrun_qty(standardDto.getMilkrun_qty());
            standard.setOrder_limit_qty(standardDto.getOrder_limit_qty());


            updatedStandard = standardRepository.save(standard);
        } else {
            throw new Exception();
        }
        return updatedStandard;
    }


}