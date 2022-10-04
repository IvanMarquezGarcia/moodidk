package com.ivan.eloy.eloysimulator.core.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Date {

	public static long LocalDateTimeMillis(LocalDateTime ldt) {
		return ldt.atZone(ZoneId.systemDefault())
		.toInstant()
		.toEpochMilli();
	}
	
}
