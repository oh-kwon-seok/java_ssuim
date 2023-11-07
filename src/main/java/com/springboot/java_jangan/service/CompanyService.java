package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.company.CompanyDto;
import com.springboot.java_jangan.data.dto.company.CompanySearchDto;
import com.springboot.java_jangan.data.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<Company> getTotalCompany(CompanySearchDto companySearchDto);

    List<Company> getCompany(CompanySearchDto companySearchDto);


    Company saveCompany(CompanyDto companyDto) throws Exception;

    Company updateCompany(CompanyDto companyDto) throws Exception;

    void deleteCompany(List<Long> uid) throws Exception;


}
