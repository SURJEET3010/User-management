package com.usm.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usm.entity.CityEntity;

@Repository
public interface CityRepository  extends JpaRepository<CityEntity, Serializable>{

	@Query(value = "select * `user_management`.`city` WHERE state_id=?1" , nativeQuery= true)
	public List<CityEntity> findByStateId(@Param("state_id") String stateId);

}
