package io.zandona.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import io.zandona.model.Message;
import io.zandona.repository.MessageRepository;

@Component
@EnableBinding(Sink.class)
public class InstantMessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(InstantMessageListener.class);
	
	@Autowired
	private MessageRepository repository;
	
	
	@StreamListener(Sink.INPUT)
	public void processMessage(InstantMessage im) {
		LOG.info("Message received - from: {}, to: {}, message: {}", im.getFrom().getDisplayName(), im.getTo().getDisplayName(), im.getMessage() );
		
		Message message = new Message();
		message.setFromEmailAddress(im.getFrom().getEmailAddress());
		message.setToEmailAddress(im.getTo().getEmailAddress());
		message.setMessage(im.getMessage());
		
		Message storedMessage = repository.save(message);
		
		LOG.info("Message stored to database - id: {}", storedMessage.getId());
	}
	
	
}
