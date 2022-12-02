package com.ivan.moodidk.core.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Date {

	public static long LocalDateTimeToMillis(LocalDateTime ldt) {
		return ldt.atZone(ZoneId.systemDefault())
		.toInstant()
		.toEpochMilli();
	}
	
}
