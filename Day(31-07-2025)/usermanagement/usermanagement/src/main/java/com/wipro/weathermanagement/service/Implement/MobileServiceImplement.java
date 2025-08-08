package com.wipro.weathermanagement.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.weathermanagement.dto.Mobile;
import com.wipro.weathermanagement.repository.MobileRepository;
import com.wipro.weathermanagement.services.MobileService;
@Service
public class MobileServiceImplement implements MobileService{
	
	@Autowired
    private MobileRepository mobileRepository;

	@Override
	public void saveMobile(Mobile mobile) {
		 mobileRepository.save(mobile);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mobile getMobileById(int id) {
		  return mobileRepository.findById(id);
		// TODO Auto-generated method stub
	
	}

	@Override
	public String updateMobile(int id, Mobile mobile) {
		// TODO Auto-generated method stub
		return mobileRepository.update(id, mobile);
	}

	@Override
	public String deleteMobile(int id) {
		// TODO Auto-generated method stub
		return mobileRepository.delete(id);
	}

	

}
