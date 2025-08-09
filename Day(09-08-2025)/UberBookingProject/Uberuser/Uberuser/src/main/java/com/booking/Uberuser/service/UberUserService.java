package com.booking.Uberuser.service;

import com.booking.Uberuser.entity.UberUser;

public interface UberUserService {
	
	void book(UberUser user);
	
	void sentUserDetails(UberUser user);

}
