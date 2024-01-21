package com.springboot.java_ssuim.data.dao;


import com.springboot.java_ssuim.data.dto.standard.StandardDto;
import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.entity.Standard;

import java.util.List;


public interface StandardDAO {



    List<Standard> selectStandard(StandardSearchDto standardSearchDto);


    Standard updateStandard(StandardDto standardDto) throws Exception;


}
