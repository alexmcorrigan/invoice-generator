package com.mcorrigal.invoiceGenerator.features.concordion;

import java.text.ParseException;

import org.concordion.integration.junit3.ConcordionTestCase;

import com.mcorrigal.invoiceGenerator.InvoiceAmount;
import com.mcorrigal.invoiceGenerator.InvoiceDate;
import com.mcorrigal.invoiceGenerator.Week;
import com.mcorrigal.invoiceGenerator.WorkPlacement;
import com.mcorrigal.invoiceGenerator.features.shared.InvoiceFeatureTestFixture;

public class InvoiceConcordionTest extends ConcordionTestCase {

	private InvoiceFeatureTestFixture fixture;
	
	public void initialise() {
		fixture = new InvoiceFeatureTestFixture();
	}
	
	public void collectWeekForInvoice(String weekBeginning, int daysWorked, String workPlaceDescription, String dayRate) throws ParseException {
		fixture.collectInvoiceWeek(new Week(
				new InvoiceDate(weekBeginning), 
				new WorkPlacement(workPlaceDescription, InvoiceAmount.create(dayRate)), 
				daysWorked));
	}
	
	public void generateInvoice(String invoiceDate, String invoiceNumber) throws ParseException {
		fixture.generateInvoice(invoiceDate, invoiceNumber);
	}
	
	public String getGrossAmountForWeek(String weekBeginning, String workPlaceDescription) throws ParseException {
		return fixture.getGrossAmountForWeek(weekBeginning, workPlaceDescription);
	}
	
	public String getInvoiceSubTotal() {
		return fixture.getInvoiceSubTotal();
	}
	
	public String getInvoiceVat() {
		return fixture.getInvoiceVat();
	}
	
	public String getInvoiceTotal() {
		return fixture.getInvoiceTotal();
	}
	
}
