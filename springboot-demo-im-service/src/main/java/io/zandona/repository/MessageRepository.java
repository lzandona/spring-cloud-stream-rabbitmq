package io.zandona.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.zandona.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

	public List<Message> findByFromEmailAddressStartingWith(String toEmailAddress);
	
	public List<Message> findByToEmailAddressStartingWith(String toEmailAddress);
	
}
