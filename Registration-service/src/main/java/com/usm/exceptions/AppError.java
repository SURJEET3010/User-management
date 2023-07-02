package com.usm.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppError {
	private String errorCode;
	private String msg;

}
