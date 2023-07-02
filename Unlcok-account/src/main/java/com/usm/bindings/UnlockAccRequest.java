package com.usm.bindings;

import lombok.Data;

@Data
public class UnlockAccRequest {

	private String email;
	private String temp_password;
	private String new_password;
	
}
