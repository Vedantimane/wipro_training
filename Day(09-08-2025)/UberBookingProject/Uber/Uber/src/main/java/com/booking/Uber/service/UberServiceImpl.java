package com.booking.Uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.booking.Uber.dto.UberUser;
import com.booking.Uber.entity.Uber;
import com.booking.Uber.repository.UberRepository;
import com.booking.Uber.util.AppConstant;

@Service
public class UberServiceImpl implements UberService {  // <-- add implements UberService
	
	@Autowired
	UberRepository uberRepository;
	
	@Autowired
	KafkaTemplate kafkaTemplate;
	
	@KafkaListener(topics=AppConstant.INCOMING_TOPIC_NAME, groupId="uber_user")
	public void receiveUberUser(UberUser uberUser) {
		System.out.println("---Message Received by Bank---"+uberUser);
		Uber uber = uberRepository.findByUberId(uberUser.getUberId());
		// your logic here
		uberUser.setStatus(true);
		uberRepository.save(uber);
		kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, uber);
	} 
		
	@Override
	public void save(Uber uber) {
		uberRepository.save(uber);
	}

	
}
