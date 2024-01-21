package com.springboot.java_ssuim.data.repository.standard;

import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_ssuim.controller.StandardController;
import com.springboot.java_ssuim.data.dto.standard.StandardSearchDto;
import com.springboot.java_ssuim.data.entity.Standard;
import com.springboot.java_ssuim.data.entity.QStandard;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class StandardRepositoryCustomImpl extends QuerydslRepositorySupport implements StandardRepositoryCustom {

    public StandardRepositoryCustomImpl(){
        super(Standard.class);
    }
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(StandardController.class);


    @Override
    public List<Standard> findInfo(StandardSearchDto StandardSearchDto){

        QStandard standard = QStandard.standard;

        Predicate used = standard.used.eq(1);

        List<Standard> standardList = from(standard)
                .select(standard)
                .where(used)
                .fetch();

        return standardList;
    }


}