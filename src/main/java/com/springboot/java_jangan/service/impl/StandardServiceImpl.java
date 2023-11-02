package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.StandardDAO;
import com.springboot.java_jangan.data.dto.standard.StandardDto;

import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;
import com.springboot.java_jangan.data.entity.Standard;
import com.springboot.java_jangan.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardServiceImpl implements StandardService {
    private final StandardDAO standardDAO;

    @Autowired
    public StandardServiceImpl(@Qualifier("standardDAOImpl") StandardDAO standardDAO){
        this.standardDAO = standardDAO;
    }
    @Override
    public List<Standard> getTotalStandard(StandardSearchDto standardSearchDto){
        return standardDAO.selectTotalStandard(standardSearchDto);
    }

    @Override
    public List<Standard> getStandard(StandardSearchDto standardSearchDto){
        return standardDAO.selectStandard(standardSearchDto);
    }
    @Override
    public Standard saveStandard(StandardDto standardDto) throws Exception {

        return standardDAO.insertStandard(standardDto);

    }
    @Override
    public Standard updateStandard(StandardDto standardDto) throws Exception {
        return standardDAO.updateStandard(standardDto);
    }
    @Override
    public void deleteStandard(List<Long> uid) throws Exception {
        standardDAO.deleteStandard(uid);
    }

}
