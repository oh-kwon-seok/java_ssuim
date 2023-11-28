package com.springboot.java_ssuim.service;

import com.springboot.java_ssuim.data.dto.SignInResultDto;
import com.springboot.java_ssuim.data.dto.SignUpResultDto;
import com.springboot.java_ssuim.data.dto.user.UserDto;
import com.springboot.java_ssuim.data.dto.user.UserSearchDto;
import com.springboot.java_ssuim.data.entity.User;

import java.util.List;

public interface SignService {


    SignUpResultDto save(UserDto userDto);

    SignUpResultDto update(UserDto userDto);

    List<User> getTotalUser(UserSearchDto userSearchDto);

    String delete(List<String> id) throws Exception;
    SignInResultDto signIn(String userId, String password) throws RuntimeException;


}
