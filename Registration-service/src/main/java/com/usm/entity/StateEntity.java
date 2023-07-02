package com.usm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="state")
public class StateEntity {

	@Id
	@Column(name="state_id")
	private String stateId;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="country_id")
	private String countryId;
}
