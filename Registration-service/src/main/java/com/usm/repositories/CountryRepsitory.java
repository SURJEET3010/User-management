 package com.usm.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usm.entity.CountryEntity;

@Repository
public interface CountryRepsitory  extends JpaRepository<CountryEntity, Serializable> {
	
}
