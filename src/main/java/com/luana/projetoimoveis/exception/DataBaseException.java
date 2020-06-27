package com.luana.projetoimoveis.exception;

import org.hibernate.boot.model.relational.Database;

public class DataBaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataBaseException(String msg) {
		super(msg);
	}

}
