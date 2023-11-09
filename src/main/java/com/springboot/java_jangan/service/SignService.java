package com.springboot.java_jangan.service;

import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.dto.user.UserDto;
import com.springboot.java_jangan.data.entity.User;

public interface SignService {


    SignUpResultDto signUp(UserDto userDto);





    SignInResultDto signIn(String userId, String password) throws RuntimeException;




}
