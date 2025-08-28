package com.backend.user_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.user_ms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserEmailAndPassWord(String email,String passWord);
	User findByUserEmail(String email);

}