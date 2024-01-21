package com.springboot.java_ssuim.service;


import com.springboot.java_ssuim.data.dto.standard.StandardDto;
import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.entity.Standard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StandardService {

 

    List<Standard> getStandard(StandardSearchDto standardSearchDto);

 
    Standard updateStandard(StandardDto standardDto) throws Exception;

 

}
