package com.usm.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usm.entity.StateEntity;


@Repository
public interface StateRepository  extends JpaRepository<StateEntity, Serializable>{

	@Query(value = "select * `user_management`.`state` WHERE country_id=?1" , nativeQuery= true)
	public List<StateEntity> findByCountryId(@Param("country_id") String countryId);

}
