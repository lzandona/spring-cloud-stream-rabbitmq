package io.zandona.repository;

import org.springframework.data.repository.CrudRepository;

import io.zandona.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
