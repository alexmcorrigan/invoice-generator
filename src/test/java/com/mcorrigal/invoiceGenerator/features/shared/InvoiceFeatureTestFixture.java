package com.mcorrigal.invoiceGenerator.features.shared;

import java.text.ParseException;

import com.mcorrigal.invoiceGenerator.Invoice;
import com.mcorrigal.invoiceGenerator.InvoiceBuilder;
import com.mcorrigal.invoiceGenerator.InvoiceDate;
import com.mcorrigal.invoiceGenerator.InvoiceWeekSet;
import com.mcorrigal.invoiceGenerator.TestConstants;
import com.mcorrigal.invoiceGenerator.Week;

public class InvoiceFeatureTestFixture {

	private InvoiceWeekSet weeks = new InvoiceWeekSet();
	private Invoice builtInvoice;
	
	public void collectInvoiceWeek(Week week) {
		weeks.add(week);
	}
	
	public void generateInvoice(String invoiceDate, String invoiceNumber) throws ParseException {
		InvoiceBuilder invoiceBuilder = new InvoiceBuilder(new InvoiceDate(invoiceDate), invoiceNumber, TestConstants.VAT_RATE);
		invoiceBuilder.appendAllWeeks(weeks);
		builtInvoice = invoiceBuilder.toInvoice();
	}
	
	public String getGrossAmountForWeek(String weekBeginDate, String workPlaceDescription) throws ParseException {
		return builtInvoice.getWeeks().getWeekFor(weekBeginDate, workPlaceDescription).getGrossAmount().toString();
	}
	
	public String getInvoiceSubTotal() {
		return builtInvoice.getInvoiceSum().getSubTotal().toString();
	}
	
	public String getInvoiceVat() {
		return builtInvoice.getInvoiceSum().getVat().toString();
	}
	
	public String getInvoiceTotal() {
		return builtInvoice.getInvoiceSum().getTotal().toString();
	}
	
}
