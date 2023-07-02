package com.usm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usm.bindings.UnlockAccRequest;
import com.usm.serviceImpl.UnlockAccServiceImpl;

@RestController
public class UnlockUserController {

	@Autowired
	private UnlockAccServiceImpl unlockService;

	@PostMapping("/unlockAccount") 
	public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccRequest request) {

		String unlockAccount = unlockService.unlockAccount(request);
		if (unlockAccount != null) {
			return ResponseEntity.ok("User Updated");
		} else {
			return ResponseEntity.ok().body("User Updated");
		}
	}
}
