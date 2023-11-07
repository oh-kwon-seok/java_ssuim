package com.springboot.java_jangan.data.dao.impl;

import com.springboot.java_jangan.data.dao.OriginDAO;
import com.springboot.java_jangan.data.dto.origin.OriginDto;
import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.entity.Origin;
import com.springboot.java_jangan.data.repository.origin.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class OriginDAOImpl implements OriginDAO {
    
    private final OriginRepository originRepository;
    @Autowired
    public OriginDAOImpl(OriginRepository originRepository){
        this.originRepository = originRepository;

    }

    public Origin insertOrigin(OriginDto originDto) throws Exception {

      

        Origin origin = new Origin();

        origin.setName(originDto.getName());
        origin.setUsed(Math.toIntExact(originDto.getUsed()));

        origin.setCreated(LocalDateTime.now());

        Origin insertOrigin = originRepository.save(origin);
        return insertOrigin;

    }
    @Override
    public List<Origin> selectTotalOrigin(OriginSearchDto originSearchDto) {
        return originRepository.findAll(originSearchDto);

    }

    @Override
    public List<Origin> selectOrigin(OriginSearchDto originSearchDto) {
        return originRepository.findInfo(originSearchDto);

    }


    @Override
    public Origin updateOrigin(OriginDto originDto) throws Exception {

      
        Optional<Origin> selectedOrigin = originRepository.findById(originDto.getUid());

        Origin updatedOrigin;

        if (selectedOrigin.isPresent()) {
            Origin origin = selectedOrigin.get();
            origin.setName(originDto.getName());
            origin.setUsed(Math.toIntExact(originDto.getUsed()));

            origin.setUpdated(LocalDateTime.now());
            updatedOrigin = originRepository.save(origin);
        } else {
            throw new Exception();
        }
        return updatedOrigin;
    }
    @Override
    public String deleteOrigin(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Origin> selectedOrigin = originRepository.findById(uid);
            if (selectedOrigin.isPresent()) {
                Origin origin = selectedOrigin.get();
                origin.setUsed(0);
                origin.setDeleted(LocalDateTime.now());
                originRepository.save(origin);
            } else {
                throw new Exception("Origin with UID " + uid + " not found.");
            }
        }
        return "Origins deleted successfully";
    }
}
