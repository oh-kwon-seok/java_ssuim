package com.springboot.java_jangan.data.repository.origin;


import com.springboot.java_jangan.data.dto.origin.OriginSearchDto;
import com.springboot.java_jangan.data.entity.Origin;

import java.util.List;

public interface OriginRepositoryCustom {
    List<Origin> findAll(OriginSearchDto OriginSearchDto);
    List<Origin> findInfo(OriginSearchDto OriginSearchDto);

}
