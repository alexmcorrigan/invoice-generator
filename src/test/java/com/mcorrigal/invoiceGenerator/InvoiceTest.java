package com.mcorrigal.invoiceGenerator;

import java.text.ParseException;

import org.junit.Test;

public class InvoiceTest {

	@Test
	public void testToString() throws ParseException {
		System.out.println(TestConstants.dummyInvoice(3).toString());
	}

}
