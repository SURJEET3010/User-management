package com.usm;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.usm.prop.AppProperties;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		AppProperties appProperties = new AppProperties();
		
		Map<String, String> messages = appProperties.getMessages();

		System.out.println(messages); 
		String reg = messages.get("regMailSubject");
		System.out.println(reg);
		
	}

}
