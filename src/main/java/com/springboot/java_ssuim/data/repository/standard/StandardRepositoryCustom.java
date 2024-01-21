package com.springboot.java_ssuim.data.repository.standard;

import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.entity.Standard;

import java.util.List;

public interface StandardRepositoryCustom {


    List<Standard> findInfo(StandardSearchDto standardSearchDto);


}
