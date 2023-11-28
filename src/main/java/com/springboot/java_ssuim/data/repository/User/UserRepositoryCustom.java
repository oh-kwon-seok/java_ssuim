package com.springboot.java_ssuim.data.repository.User;

import com.springboot.java_ssuim.data.dto.user.UserSearchDto;
import com.springboot.java_ssuim.data.entity.User;

import java.util.List;

public interface UserRepositoryCustom {



    List<User> findAll(UserSearchDto userSearchDto);
    List<User> findInfo(UserSearchDto userSearchDto);

}
