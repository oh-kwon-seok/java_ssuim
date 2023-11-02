package com.springboot.java_jangan.data.repository.standard;


import com.springboot.java_jangan.data.dto.standard.StandardSearchDto;
import com.springboot.java_jangan.data.entity.Standard;

import java.util.List;

public interface StandardRepositoryCustom {
    List<Standard> findAll(StandardSearchDto StandardSearchDto);
    List<Standard> findInfo(StandardSearchDto StandardSearchDto);


}
