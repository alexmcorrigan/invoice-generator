package com.mcorrigal.invoiceGenerator;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.mcorrigal.invoiceGenerator.InvoiceDate;

public class InvoiceDateTest {
	

	@Before
	public void setUp() {
	}
	
	@Test
	public void newInvoiceDateFromCalendar() {
		Calendar cal = Calendar.getInstance();;
		cal.set(2012, 1, 10);
		assertShortAndLongFormats("10/02/2012", "10 February 2012", new InvoiceDate(cal));
	}
	
	@Test
	public void newInvoiceDateFromShortString() throws ParseException {
		assertShortAndLongFormats("10/02/2012", "10 February 2012", new InvoiceDate("10/02/2012"));
	}
	
	@Test
	public void invoiceDateEquality() throws ParseException {
		InvoiceDate invDateA = new InvoiceDate("27/01/2012");
		InvoiceDate invDateB = new InvoiceDate("27/01/2012");
		assertTrue(invDateA.equals(invDateB));
	}
	
	
	private void assertShortAndLongFormats(String expectedShortString, String expectedLongString, InvoiceDate invDate) {
		assertEquals(expectedShortString, invDate.toShortString());
		assertEquals(expectedLongString, invDate.toLongString());
	}

}
