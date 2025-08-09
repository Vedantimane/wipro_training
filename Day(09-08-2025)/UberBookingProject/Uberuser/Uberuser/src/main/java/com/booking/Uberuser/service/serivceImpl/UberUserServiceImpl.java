package com.booking.Uberuser.service.serivceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.booking.Uberuser.entity.UberUser;
import com.booking.Uberuser.repository.UberUserRepository;
import com.booking.Uberuser.service.UberUserService;
import com.booking.Uberuser.util.AppConstant;

@Service
public class UberUserServiceImpl implements UberUserService {
	
	@Autowired
	UberUserRepository uberUserRepository;
	@Autowired
	KafkaTemplate kafkaTemplate;
	

	@Override
	public void book(UberUser user) {
		// TODO Auto-generated method stub

		uberUserRepository.save(user);
		  kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, user);
	}

	@Override
	public void sentUserDetails(UberUser user) {
		// TODO Auto-generated method stub

	}

}
