package com.usm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.usm.bindings.UnlockAccRequest;
import com.usm.constants.Constants;
import com.usm.entity.UserEntity;
import com.usm.repositories.UserRepository;
import com.usm.service.UnlockAccService;

public class UnlockAccServiceImpl implements UnlockAccService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String unlockAccount(UnlockAccRequest unlockReq) {
		UserEntity user = userRepo.findByUserEmailAndPwd(unlockReq.getEmail(), unlockReq.getTemp_password());
		if(user!= null) {
			user.setPassword(unlockReq.getNew_password());
			user.setAccountStatus(Constants.UNLOCKED);
			userRepo.save(user);
			return Constants.UNLOCK_SUCCESS;
		}
		
		return Constants.UNLOCK_FAIL;
	}

}
