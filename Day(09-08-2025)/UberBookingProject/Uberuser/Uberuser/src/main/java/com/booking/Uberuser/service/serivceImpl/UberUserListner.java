package com.booking.Uberuser.service.serivceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.booking.Uberuser.entity.UberUser;
import com.booking.Uberuser.repository.UberUserRepository;
import com.booking.Uberuser.util.AppConstant;

@Service
public class UberUserListner {
	
	@Autowired
	UberUserRepository uberUserRepository;
	
	@KafkaListener(topics=AppConstant.INCOMING_TOPIC_NAME,groupId="uber_user")
	void processUberDetails(UberUser uberUser)
	{
		
		System.out.println("--Message Received by UberUser="+uberUser);
		UberUser uberUserDB=uberUserRepository.findById(uberUser.getUberUserId()).get();
		uberUserDB.setStatus(uberUser.isStatus());
		uberUserRepository.save(uberUserDB);
		
	}

}
