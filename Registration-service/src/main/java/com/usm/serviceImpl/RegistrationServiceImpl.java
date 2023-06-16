package com.usm.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.bindings.User;
import com.usm.entity.CityEntity;
import com.usm.entity.CountryEntity;
import com.usm.entity.StateEntity;
import com.usm.entity.UserEntity;
import com.usm.repositories.CityRepository;
import com.usm.repositories.CountryRepsitory;
import com.usm.repositories.StateRepository;
import com.usm.repositories.UserRepository;
import com.usm.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CountryRepsitory countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public boolean checkUniqueEmail(String email) {
		UserEntity userEntity = userRepo.findByUserEmail(email);
		if (userEntity == null)
			return false;
		return true;
	}

	@Override
	public Map<String, String> getCountries() {

		List<CountryEntity> allCountries = countryRepo.findAll();
		Map<String, String> map = new HashMap<>();

		for (CountryEntity entity : allCountries) {
			map.put(entity.getCountryId(), entity.getCountryName());
		}

		return map;
	}

	@Override
	public Map<String, String> getStates(String countryId) {
		List<StateEntity> states = stateRepo.findByCountryId(countryId);
		
		Map<String, String> map = new HashMap<>();
		
		for(StateEntity entity: states) {
			map.put(entity.getStateId(), entity.getStateName());
		}
		return map;
	}

	@Override
	public Map<String, String> getCities(String stateId) {
		
		List<CityEntity> cities = cityRepo.findByStateId(stateId);
		
		Map<String, String> cityMap = new HashMap<>();
		
		for(CityEntity entity: cities) {
			cityMap.put(entity.getCityId(), entity.getCityName());
		}
		return cityMap;
		
	}

	@Override
	public boolean registerUser(User user) {
		user.setPassword(getTempPassword());
		user.setAccountStatus("LOCKED");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		UserEntity newUser = userRepo.save(userEntity);
		if(newUser.getUserId() != null) {
			return sendRegistrationEmail(user); 
		}
		
		return false;
	}
	
	private String getTempPassword() {

		return null;
	}

	private boolean sendRegistrationEmail(User user) {
		return false;
	}
}
