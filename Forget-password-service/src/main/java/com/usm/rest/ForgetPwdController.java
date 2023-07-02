package com.usm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usm.serviceImpl.ForgetPwdServiceImpl;

@RestController
public class ForgetPwdController {

	@Autowired
	private ForgetPwdServiceImpl service;
	
	@PostMapping("forget/{email}")
	public String forgetPassword(@PathVariable String email) {
		service.foretPassword(email);
		return null;
	}

}
