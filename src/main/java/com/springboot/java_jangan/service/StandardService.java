package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.standard.StandardDto;
import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;

import com.springboot.java_jangan.data.entity.Standard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StandardService {
    List<Standard> getTotalStandard(StandardSearchDto standardSearchDto);

    List<Standard> getStandard(StandardSearchDto standardSearchDto);


    Standard saveStandard(StandardDto standardDto) throws Exception;

    Standard updateStandard(StandardDto standardDto) throws Exception;

    void deleteStandard(List<Long> uid) throws Exception;


}
