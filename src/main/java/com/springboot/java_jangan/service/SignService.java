package com.springboot.java_jangan.service;

import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;

public interface SignService {


    SignUpResultDto signUp(String userId, String password, String userName, String userAuth);

    SignInResultDto signIn(String userId, String password) throws RuntimeException;




}
