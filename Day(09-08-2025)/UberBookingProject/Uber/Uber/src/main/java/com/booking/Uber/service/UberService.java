package com.booking.Uber.service;

import java.util.List;

import com.booking.Uber.dto.UberUser;
import com.booking.Uber.entity.Uber;

public interface UberService {
    void receiveUberUser(UberUser uberUser);
    void save(Uber uber);
	List<Uber> findAll();
}
