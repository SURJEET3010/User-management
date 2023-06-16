package com.usm.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usm.entity.CityEntity;

@Repository
public interface CityRepository  extends JpaRepository<CityEntity, Serializable>{

	public List<CityEntity> findByStateId(String stateId);

}
