package io.zandona.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseResponse implements Serializable {

	private Status status;
	
	
	public BaseResponse() {
		this(new Status());
	}
	
	public BaseResponse(Status status) {
		this.status = status;
	}
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
