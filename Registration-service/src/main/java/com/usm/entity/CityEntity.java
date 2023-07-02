package com.usm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="city")
public class CityEntity {

	@Id 
	@Column(name="city_id")
	private String cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="state_id")
	private String stateId;
}
