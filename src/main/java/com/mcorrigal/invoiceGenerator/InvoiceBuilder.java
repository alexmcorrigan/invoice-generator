package com.mcorrigal.invoiceGenerator;

import java.text.ParseException;

public class InvoiceBuilder {
	
	private InvoiceDate invoiceDate;
	private String invoiceNumber;
	private InvoiceWeekSet weeks;
	private SumCalculator sumCalculator;
	
	public InvoiceBuilder(InvoiceDate invoiceDate, String invoiceNumber, InvoiceAmount vatRate) throws ParseException {
		this.invoiceDate = invoiceDate;
		this.invoiceNumber = invoiceNumber;
		weeks = new InvoiceWeekSet();
		sumCalculator = new SumCalculator(vatRate);
	}
	
	public void appendWeek(Week week) {
		weeks.add(week);
	}
	
	public void appendAllWeeks(InvoiceWeekSet newWeeks) {
		for (Week week : newWeeks) {
			weeks.add(week);
		}
	}
	
	public Invoice toInvoice() {
		return new Invoice(invoiceDate, invoiceNumber, weeks, sumCalculator.calculate(weeks));
	}
	
}
