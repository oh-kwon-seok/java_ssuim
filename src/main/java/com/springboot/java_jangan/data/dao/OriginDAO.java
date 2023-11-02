package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.dto.origin.OriginDto;
import com.springboot.java_jangan.data.entity.Origin;


import java.util.List;


public interface OriginDAO {

    Origin insertOrigin(OriginDto originDto) throws Exception;

    List<Origin> selectTotalOrigin(OriginSearchDto OriginSearchDto);
    List<Origin> selectOrigin(OriginSearchDto originSearchDto);

    Origin updateOrigin(OriginDto originDto) throws Exception;

    String deleteOrigin(List<Long> uid) throws Exception;
    
    

}
