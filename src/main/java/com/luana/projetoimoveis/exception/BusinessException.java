package com.luana.projetoimoveis.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BusinessException(Object obj) {
		super("Business Exception: " + obj);
	}
}
