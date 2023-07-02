package com.usm.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.usm.bindings.User;
import com.usm.constants.Constants;
import com.usm.entity.UserEntity;
import com.usm.prop.AppProperties;
import com.usm.repositories.UserRepository;
import com.usm.service.ForgetPwdService;
import com.usm.util.EmailUtils;

public class ForgetPwdServiceImpl implements ForgetPwdService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private EmailUtils emailUtil;
	
	@Override
	public String foretPassword(String email) {
		UserEntity user = userRepo.findByUserEmail(email);
		if(user == null) {
			return "User doesn`t exist";
		}
		
		boolean sendForgetPwdEmail = sendForgetPwdEmail(user);
		if(sendForgetPwdEmail) {
			return "Check mail for login";
		}
		
		return "Internal Error";
	}

	
	private boolean sendForgetPwdEmail(UserEntity user) {
		 boolean emailSent = false;
		 
		 /* Taking the data from yml file */
		 Map<String, String> messages = appProperties.getMessages();
		 String subject = messages.get("regMailSubject");
		 String body = readMailBody("regMailBodyFile",user);
		 
		 //String body ="<h1> Hello {user.getName()} !</h1> <br> Your temporary password is " + "";
		 emailSent = emailUtil.sendMail(user.getEmail(), body, subject); 
		return emailSent;
	}
	
	public String readMailBody(String filename, UserEntity user) {
		
		String mailBody = null;
		StringBuffer buffer = new StringBuffer();
		
		Path path = Paths.get(filename);
		
		try(Stream<String> stream = Files.lines(path)){
			stream.forEach(line->{
				buffer.append(line);
			});
			
			mailBody = buffer.toString();
			mailBody = mailBody.replace(Constants.FNAME, user.getFirstname());
			mailBody = mailBody.replace(Constants.PWD, user.getPassword());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	}
}
