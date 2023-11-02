package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.standard.StandardDto;
import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;
import com.springboot.java_jangan.data.entity.Standard;

import java.util.List;


public interface StandardDAO {

    Standard insertStandard(StandardDto standardDto);

  

    
    List<Standard> selectTotalStandard(StandardSearchDto StandardSearchDto);
    List<Standard> selectStandard(StandardSearchDto standardSearchDto);

    Standard updateStandard(StandardDto standardDto) throws Exception;

    String deleteStandard(List<Long> uid) throws Exception;


}
