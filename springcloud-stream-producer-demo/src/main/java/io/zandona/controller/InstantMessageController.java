package io.zandona.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.zandona.messaging.InstantMessage;
import io.zandona.model.BaseResponse;
import io.zandona.model.Status;
import io.zandona.service.InstantMessagePublisher;

@RestController
public class InstantMessageController {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private InstantMessagePublisher service;
	
	
	@PostMapping("/messages/send")
	public BaseResponse sendMessage(@RequestBody InstantMessage instantMessage) {
		BaseResponse response = null;
		
		try {
			
			service.sendMessage(instantMessage);
			
			response = new BaseResponse(new Status("0", "Message sent"));
			
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
			response = new BaseResponse(new Status("-1", e.getMessage()));
		}
		
		return response;
	}
	
}
