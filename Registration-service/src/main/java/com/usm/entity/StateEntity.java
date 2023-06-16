package com.usm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="State")
public class StateEntity {

	@Id
	@Column(name="STATE_ID")
	private String stateId;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@Column(name="CUNTRY_ID")
	private String countryId;
}
