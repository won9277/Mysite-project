package com.sds.icto.Exception;

public class BoardDaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BoardDaoException() {
		super("Create BoardDao Exception");
	}
	public BoardDaoException(String msg) {
		super(msg);
	}

}
