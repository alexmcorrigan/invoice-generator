package com.mcorrigal.invoiceGenerator;

import java.math.BigDecimal;

public class NumberUtils {

	public static BigDecimal makeDecimal(String value) {
		return new BigDecimal(value);
	}
	
	public static BigDecimal roundDecimal(BigDecimal value, int scale) {
		return value.setScale(scale);
	}
	
}
