package com.usm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="country")
public class CountryEntity {
	
	@Id
	@Column(name="COUNTRY_ID")
	private String countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
}
