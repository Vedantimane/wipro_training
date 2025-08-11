package com.booking.Uber.dto;

import lombok.Data;

@Data

public class UberUser {
	int uberUserId;
	String uberId;
	String SourceLocation;
	String destinationLocation;
	boolean status;
}