package com.usm.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usm.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

	@Query(value = "select user_email from `user_management`.`user_detail`  where `user_management`.`user_pwd` and `user_management`.`user_email` = ?1", nativeQuery =true)
	public UserEntity findByUserEmailAndPwd(@Param("user_email") String email, @Param("user_pwd") String temp_pwd);
}
