package com.mcorrigal.invoiceGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mcorrigal.invoiceGenerator.InvoiceAmount;

public class InvoiceAmountTest {

	@Test
	public void newAmountFromStringRepresentations() {
		assertInvoiceMoneyFromString("100", "100.00");
		assertInvoiceMoneyFromString("1000", "1000.00");
		assertInvoiceMoneyFromString("10000", "10000.00");
		assertInvoiceMoneyFromString("100.00", "100.00");
		assertInvoiceMoneyFromString("1000.00", "1000.00");
		assertInvoiceMoneyFromString("10000.00", "10000.00");
	}
	
	@Test
	public void multiplyByInteger() {
		InvoiceAmount result = InvoiceAmount.create("100.25");
		assertEquals("200.50", result.multiplyBy(2).toString());
	}
	
	@Test
	public void add() {
		InvoiceAmount result = InvoiceAmount.create("100.10");
		assertEquals("300.40", result.add(InvoiceAmount.create("200.30")).toString());
	}
	
	@Test
	public void divideBy() {
		InvoiceAmount result = InvoiceAmount.create("100");
		assertEquals("33.33", result.divideBy(InvoiceAmount.create("3")).toString());
	}

	private void assertInvoiceMoneyFromString(String inputString, String expectedAmountToStringValue) {
		InvoiceAmount amount = InvoiceAmount.create(inputString);
		assertEquals(expectedAmountToStringValue, amount.toString());
	}
	
	

}
