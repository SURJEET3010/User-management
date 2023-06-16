package com.usm.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usm.entity.StateEntity;


@Repository
public interface StateRepository  extends JpaRepository<StateEntity, Serializable>{

	public List<StateEntity> findByCountryId(String countryId);

}
