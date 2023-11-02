package com.springboot.java_jangan.service.impl;

import com.springboot.java_jangan.data.dao.OriginDAO;
import com.springboot.java_jangan.data.dto.origin.OriginDto;

import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.entity.Origin;
import com.springboot.java_jangan.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {
    private final OriginDAO originDAO;

    @Autowired
    public OriginServiceImpl(@Qualifier("originDAOImpl") OriginDAO originDAO){
        this.originDAO = originDAO;
    }


    @Override
    public List<Origin> getTotalOrigin(OriginSearchDto originSearchDto){

        return originDAO.selectTotalOrigin(originSearchDto);


    }

    @Override
    public List<Origin> getOrigin(OriginSearchDto originSearchDto){
        return originDAO.selectOrigin(originSearchDto);
    }

    @Override
    public Origin saveOrigin(OriginDto originDto) throws Exception {

        return originDAO.insertOrigin(originDto);

    }
    @Override
    public Origin updateOrigin(OriginDto originDto) throws Exception {
        return originDAO.updateOrigin(originDto);
    }
    @Override
    public void deleteOrigin(List<Long> uid) throws Exception {
        originDAO.deleteOrigin(uid);
    }

}
