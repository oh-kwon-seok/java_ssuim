package com.springboot.java_jangan.data.repository;

import com.springboot.java_jangan.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getById(String id);
}
