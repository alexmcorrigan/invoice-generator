package com.mcorrigal.invoiceGenerator;

import java.text.ParseException;

import com.mcorrigal.invoiceGenerator.Invoice;
import com.mcorrigal.invoiceGenerator.InvoiceAmount;
import com.mcorrigal.invoiceGenerator.InvoiceDate;
import com.mcorrigal.invoiceGenerator.InvoiceWeekSet;
import com.mcorrigal.invoiceGenerator.SumCalculator;
import com.mcorrigal.invoiceGenerator.Week;
import com.mcorrigal.invoiceGenerator.WorkPlacement;

public class TestConstants {

	public static SumCalculator SUM_CALCULATOR;
	public static final InvoiceAmount VAT_RATE = InvoiceAmount.create("20");
	public static final String INVOICE_DATE = "10/02/2012";
	public static final InvoiceAmount DAY_RATE = InvoiceAmount.create("500");
	
	public static InvoiceWeekSet dummyWeeks(int numberOfWeeks) throws ParseException {
		InvoiceWeekSet weeks = new InvoiceWeekSet();
		for (int i = 0; i < numberOfWeeks; i++) {
			weeks.add(dummyWeek(i));
		}
		return weeks;
	}
	
	public static Invoice dummyInvoice(int numberOfWeeks) throws ParseException {
		InvoiceWeekSet weeks = dummyWeeks(numberOfWeeks);
		return new Invoice(new InvoiceDate(INVOICE_DATE), "INV-001", weeks, sumCalculator().calculate(weeks));
	}
	
	private static SumCalculator sumCalculator() {
		if (SUM_CALCULATOR == null) SUM_CALCULATOR = new SumCalculator(VAT_RATE);
		return SUM_CALCULATOR;
	}

	public static Week dummyWeek() throws ParseException {
		return dummyWeek(INVOICE_DATE, "some-work-01");
	}
	
	public static Week dummyWeek(int sequence) throws ParseException {
		return dummyWeek(INVOICE_DATE, "some-work-" +  sequence);
	}

	public static Week dummyWeek(String dateString, String description) throws ParseException {
		return new Week(new InvoiceDate(dateString), dummyWorkPlacement(description), 5);
	}
	
	public static WorkPlacement dummyWorkPlacement(String description) {
		return new WorkPlacement(description, DAY_RATE);
	}
	
}
