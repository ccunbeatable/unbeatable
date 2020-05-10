package com.containercrush.unbeatable.model;

import java.util.List;

public class ApiResponse {

	private int status;
	private String message;
	private Object result;
	private List<User> usrList;
	
	public ApiResponse(int status, String message, Object result) {
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public ApiResponse(int status, String message, List<User> usrList) {
		this.status = status;
		this.message = message;
		this.usrList = usrList;
	}
	
	
	public List<User> getUsrList() {
		return usrList;
	}


	public void setUsrList(List<User> usrList) {
		this.usrList = usrList;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
