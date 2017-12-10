package io.zandona.messaging;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class InstantMessage implements Serializable {

	@NotNull
	@Valid
	private Recipient from;
	
	@NotNull
	@Valid
	private Recipient to;
	
	@NotNull
	private String message;
	

	public Recipient getFrom() {
		return from;
	}

	public void setFrom(Recipient from) {
		this.from = from;
	}

	public Recipient getTo() {
		return to;
	}

	public void setTo(Recipient to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
