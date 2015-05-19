package com.sds.icto.Exception;

public class MemberDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberDaoException() {
		super("Create MemberDao Exception");

	}

	public MemberDaoException(String msg) {
		super(msg);
	}

}
