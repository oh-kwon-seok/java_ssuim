package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.company.CompanyDto;
import com.springboot.java_jangan.data.dto.company.CompanySearchDto;
import com.springboot.java_jangan.data.entity.Company;

import java.util.List;


public interface CompanyDAO {
    Company insertCompany(CompanyDto companyDto);

    List<Company> selectTotalCompany(CompanySearchDto CompanySearchDto);
    List<Company> selectCompany(CompanySearchDto companySearchDto);

    Company updateCompany(CompanyDto companyDto) throws Exception;

    String deleteCompany(List<Long> uid) throws Exception;


}
