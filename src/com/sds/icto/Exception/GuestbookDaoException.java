package com.sds.icto.Exception;

public class GuestbookDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GuestbookDaoException() {
		super("Create GuestbookDao Exception");

	}

	public GuestbookDaoException(String msg) {
		super(msg);
	}
}
