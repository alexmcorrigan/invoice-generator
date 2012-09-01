package com.mcorrigal.invoiceGenerator.features.jbehave;

import static junit.framework.Assert.assertEquals;

import java.text.ParseException;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import com.mcorrigal.invoiceGenerator.InvoiceAmount;
import com.mcorrigal.invoiceGenerator.InvoiceDate;
import com.mcorrigal.invoiceGenerator.Week;
import com.mcorrigal.invoiceGenerator.WorkPlacement;
import com.mcorrigal.invoiceGenerator.features.shared.InvoiceFeatureTestFixture;

public class InvoiceJbehaveSteps {
	
	private InvoiceFeatureTestFixture fixture;
	private String invoiceDate;
	private String invoiceNumber;
	
	@Given("an invoice date of $invoiceDate and invoice number is $invoiceNumber")
	public void newInvoice(String invoiceDate, String invoiceNumber) {
		fixture = new InvoiceFeatureTestFixture();
		this.invoiceDate = invoiceDate;
		this.invoiceNumber = invoiceNumber;
	}
	
	@Given("I have worked these weeks: $givenWeeks")
	public void withWeeks(ExamplesTable givenWeeks) throws ParseException {
		for (Map<String,String> row : givenWeeks.getRows()) {
	        String weekBeginning = row.get("week beginning");
	        int daysWorked = Integer.valueOf(row.get("days worked"));
	        String workPlaceDescription = row.get("work place description");
	        String dayRate = row.get("day rate");
	        Week week = new Week(new InvoiceDate(weekBeginning), new WorkPlacement(workPlaceDescription, InvoiceAmount.create(dayRate)), daysWorked);
	        fixture.collectInvoiceWeek(week);
	    }
	}
	
	@When("the invoice is generated")
	public void generateInvoice() throws ParseException {
		fixture.generateInvoice(invoiceDate, invoiceNumber);
	}
	
	@Then("the gross amount for each week is calculated at: $thenWeeks")
	public void testGrossAmountForEachWeek(ExamplesTable thenWeeks) throws ParseException {
		for (Map<String, String> row : thenWeeks.getRows()) {
			String weekBeginning = row.get("week beginning");
			String workPlaceDescription = row.get("work place description");
			String grossAmount = row.get("gross amount");
			assertEquals(grossAmount, fixture.getGrossAmountForWeek(weekBeginning, workPlaceDescription));
		}
	}
	
	@Then("the sub-total is $subTotal")
	public void testInvoiceSubTotal(String subTotal) {
		assertEquals(subTotal, fixture.getInvoiceSubTotal());
	}
	
	@Then("the VAT is $vat")
	public void testInoiceVat(String vat) {
		assertEquals(vat, fixture.getInvoiceVat());
	}
	
	@Then("the Total is $total")
	public void testInvoiceTotal(String total) {
		assertEquals(total, fixture.getInvoiceTotal());
	}
	
	
	
}
