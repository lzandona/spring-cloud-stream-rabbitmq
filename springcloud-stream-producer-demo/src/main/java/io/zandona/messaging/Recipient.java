package io.zandona.messaging;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class Recipient implements Serializable {

	@NotNull
	private String displayName;
	
	@NotNull
	private String emailAddress;
	

	
	public Recipient() {
		
	}
	
	public Recipient(String displayName, String emailAddress) {
		this.displayName = displayName;
		this.emailAddress = emailAddress;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
}
