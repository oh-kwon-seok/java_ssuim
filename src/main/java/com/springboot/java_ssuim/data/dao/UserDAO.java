package com.springboot.java_ssuim.data.dao;

import com.springboot.java_ssuim.data.dto.user.UserSearchDto;
import com.springboot.java_ssuim.data.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> selectTotalUser(UserSearchDto userSearchDto);




}
