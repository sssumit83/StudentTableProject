package com.te.assignment;

public class StudentException extends RuntimeException {
	String msg;

	public StudentException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "StudentException [msg=" + msg + "]";
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
