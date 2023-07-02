package com.usm.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usm.bindings.User;
import com.usm.constants.Constants;
import com.usm.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService regService;

	@GetMapping("/checkEMail/{mail}")
	public ResponseEntity<String> checkMail(@PathVariable String mail) {
		String status;

		boolean checkUniqueEmail = regService.checkUniqueEmail(mail);
		if (checkUniqueEmail) {
			status = Constants.UNIQUE;
		} else {
			status = Constants.DUPLICATE;
		}
		return ResponseEntity.ok().body(status);
	}

	@GetMapping("/countries")
	public Map<String, String> getCountries() {
		Map<String, String> countries = regService.getCountries();
		return countries;
	};

	@GetMapping("states/{countryId}")
	public ResponseEntity<Map<String, String>> getStates(@PathVariable String countryId) {
		Map<String, String> states = regService.getStates(countryId);
		return ResponseEntity.ok().body(states);
	}

	@GetMapping("cities/{stateId}")
	public ResponseEntity<Map<String, String>> getCity(@PathVariable String stateId) {
		Map<String, String> cities = regService.getCities(stateId);
		return ResponseEntity.ok().body(cities);
	}

	@PostMapping("/saveuser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		String status;
		boolean registerUser = regService.registerUser(user);
		if (registerUser) {
			status = Constants.SUCCESS;
			return ResponseEntity.created(null).body(status);
		} else {
			status = Constants.FAIL;
			return ResponseEntity.internalServerError().body(status);
		}
		
	}

}
