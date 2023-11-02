package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.origin.OriginDto;

import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.entity.Origin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OriginService {

    List<Origin> getTotalOrigin(OriginSearchDto originSearchDto);

    List<Origin> getOrigin(OriginSearchDto originSearchDto);


    Origin saveOrigin(OriginDto originDto) throws Exception;

    Origin updateOrigin(OriginDto originDto) throws Exception;

    void deleteOrigin(List<Long> uid) throws Exception;

}
