package com.usm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.bindings.LoginRequest;
import com.usm.constants.Constants;
import com.usm.entity.UserEntity;
import com.usm.repositories.UserRepository;
import com.usm.service.LoginRequestService;

@Service
public class LoginRequestServiceImpl implements LoginRequestService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public String login(LoginRequest request) {

		UserEntity user = userRepo.findByUserEmailAndPwd(request.getEmail(), request.getPassword());

		if (user == null) {
			return "";
		}

		if (user.getAccountStatus() == Constants.LOCKED) {
			return "Account Locked";
		}

		return "Invalid credential";
	}
}
