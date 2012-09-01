package com.mcorrigal.invoiceGenerator;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

import com.mcorrigal.invoiceGenerator.InvoiceSum;
import com.mcorrigal.invoiceGenerator.SumCalculator;

public class SumCalculatorTest {
	
	@Test
	public void calculateSumForManyWeeks() throws ParseException {
		SumCalculator sumCalc = new SumCalculator(TestConstants.VAT_RATE);
		InvoiceSum sum = sumCalc.calculate(TestConstants.dummyWeeks(3));
		assertEquals("7500.00", sum.getSubTotal().toString());
		assertEquals("1500.00", sum.getVat().toString());
		assertEquals("9000.00", sum.getTotal().toString());
	}
	
}
