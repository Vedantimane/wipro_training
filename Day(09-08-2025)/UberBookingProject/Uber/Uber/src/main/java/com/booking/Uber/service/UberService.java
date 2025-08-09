package com.booking.Uber.service;

import com.booking.Uber.dto.UberUser;
import com.booking.Uber.entity.Uber;

public interface UberService {
    void receiveUberUser(UberUser uberUser);
    void save(Uber uber);
}
