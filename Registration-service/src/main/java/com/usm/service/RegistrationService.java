package com.usm.service;

import java.util.Map;

import com.usm.bindings.User;

public interface RegistrationService {

	public boolean checkUniqueEmail(String email);
	
	public Map<String, String> getCountries();
	
	public Map<String, String> getStates(String countryId);
	
	public Map<String, String> getCities(String stateId);
	
	public boolean registerUser(User user);
	
}
