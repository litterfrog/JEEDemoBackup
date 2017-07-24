package com.fxp.springmvc.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="Êý×Ö²»¼ªÀû!")
public class MyNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
