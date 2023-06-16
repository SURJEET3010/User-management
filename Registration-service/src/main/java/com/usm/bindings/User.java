package com.usm.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {

	private String userId;
	private String firstname;
	private String lastname;
	private String email;
	private int contact;
	private LocalDate dateOfBirth;
	private String city;
	private String state;
	private String country;
	private String password;
	private String accountStatus;
	private LocalDate createdDate;
	private LocalDate updateDate;
	
}
