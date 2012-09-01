package com.mcorrigal.invoiceGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

import com.mcorrigal.invoiceGenerator.InvoiceWeekSet;
import com.mcorrigal.invoiceGenerator.Week;

public class InvoiceWeekSetTest {

	@Test
	public void newInvoiceWeek() throws ParseException {
		InvoiceWeekSet weeks = new InvoiceWeekSet();
		Week dummyWeek = TestConstants.dummyWeek("21/01/2012", "some work");
		Week dummyWeekDupe = TestConstants.dummyWeek("21/01/2012", "some work");
		weeks.add(dummyWeek);
		assertEquals(1, weeks.size());
		weeks.add(dummyWeekDupe);
		assertEquals(1, weeks.size());
	}
	
	@Test
	public void contains() throws ParseException {
		InvoiceWeekSet weeks = new InvoiceWeekSet();
		weeks.add(TestConstants.dummyWeek("21/01/2012", "some work"));
		Week dummyWeekDupe = TestConstants.dummyWeek("21/01/2012", "some work");
		Week aDifferentWeek = TestConstants.dummyWeek("22/01/2012", "some other work");
		assertTrue(weeks.contains(dummyWeekDupe));
		assertFalse(weeks.contains(aDifferentWeek));
	}
	
	@Test
	public void containsWeekWith() throws ParseException {
		String weekBeginDate = "21/01/2012";
		String workPlaceDescription = "some work";
		InvoiceWeekSet weeks = new InvoiceWeekSet();
		weeks.add(TestConstants.dummyWeek(weekBeginDate, workPlaceDescription));
		assertTrue(weeks.containsWeekWith(weekBeginDate, workPlaceDescription));
		assertFalse(weeks.containsWeekWith("22/01/2012", "ner"));
	}

}
