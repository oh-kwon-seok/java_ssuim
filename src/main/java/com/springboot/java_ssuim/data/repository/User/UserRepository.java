package com.springboot.java_ssuim.data.repository.User;

import com.springboot.java_ssuim.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepositorySupport")
public interface UserRepository extends JpaRepository<User,String>, UserRepositoryCustom {

    User getById(String id);


}
