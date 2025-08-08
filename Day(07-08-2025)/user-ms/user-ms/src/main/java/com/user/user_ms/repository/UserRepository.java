package com.user.user_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.user_ms.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

}
