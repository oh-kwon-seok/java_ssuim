package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.type.TypeDto;
import com.springboot.java_jangan.data.dto.type.TypeSearchDto;
import com.springboot.java_jangan.data.entity.Type;

import java.util.List;


public interface TypeDAO {
    Type insertType(TypeDto typeDto);

    List<Type> selectTotalType(TypeSearchDto TypeSearchDto);
    List<Type> selectType(TypeSearchDto typeSearchDto);

    Type updateType(TypeDto typeDto) throws Exception;

    String deleteType(List<Long> uid) throws Exception;


}
