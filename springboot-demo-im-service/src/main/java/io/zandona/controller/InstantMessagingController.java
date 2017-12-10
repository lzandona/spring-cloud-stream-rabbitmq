package io.zandona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.zandona.model.Message;
import io.zandona.repository.MessageRepository;

@RestController
public class InstantMessagingController {

	@Autowired
	private MessageRepository repository;
	
	@GetMapping("/messages/to/{email}")
	public List<Message> getUserMessages(@PathVariable(name = "email") String userEmailAddress) {
		return repository.findByToEmailAddressStartingWith(userEmailAddress);
	}
	
}
