package com.usm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usm.bindings.LoginRequest;
import com.usm.service.LoginRequestService;

@RestController
public class LoginController {

	@Autowired
	private LoginRequestService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {
		String login = loginService.login(request);
		if (login != null) {
			return ResponseEntity.ok().body(login);
		}
		return ResponseEntity.internalServerError().body(login);
	}
}