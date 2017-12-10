package io.zandona.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import io.zandona.messaging.InstantMessage;

@Component
@EnableBinding(Source.class)
public class InstantMessagePublisher {

	private Source source;
	
	public InstantMessagePublisher(Source source) {
		this.source = source;
	}
	
	public void sendMessage(InstantMessage instantMessage) {
		Message<InstantMessage> message = MessageBuilder
				.withPayload(instantMessage)
				.build();
		
		source.output().send(message);
	}
	
	
}
