package com.usm.entity;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="user_detail")
public class UserEntity {

	@Id
//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, strategy = "com.ums.entity.CustomIdGenerator", parameters = {
//	@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "USR00") })
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_firstname")
	private String firstname;
	
	@Column(name="user_lastname")
	private String lastname;
	
	@Column(name="user_email", unique= true)
	private String email;
	
	@Column(name="user_contact")
	private int contact;
	
	@Column(name="user_date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="user_city")
	private String city;
	
	@Column(name="user_state")
	private String state;
	
	@Column(name="user_country")
	private String country;
	
	@Column(name="user_passowrd")
	private String password;
	
	@Column(name="user_account_status")
	private String accountStatus;
	
	@Column(name="created_data")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="uptated_date")
	@CreationTimestamp
	private LocalDate updateDate;
	
}
