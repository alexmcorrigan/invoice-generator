package com.mcorrigal.invoiceGenerator.features.cucumber;

import static com.mcorrigal.invoiceGenerator.features.cucumber.FeatureStringPatterns.FREE_TEXT;
import static com.mcorrigal.invoiceGenerator.features.cucumber.FeatureStringPatterns.MONEY_DECIMAL;
import static com.mcorrigal.invoiceGenerator.features.cucumber.FeatureStringPatterns.SHORT_DATE;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import com.mcorrigal.invoiceGenerator.features.shared.InvoiceFeatureTestFixture;
import com.mcorrigal.invoiceGenerator.features.shared.InvoiceFeatureTestObjects.GivenWeek;
import com.mcorrigal.invoiceGenerator.features.shared.InvoiceFeatureTestObjects.ThenWeek;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class InvoiceCucumberSteps {
	
	private InvoiceFeatureTestFixture fixture;
	private String invoiceDate;
	private String invoiceNumber;
	
	@Given("^an invoice date of (" + SHORT_DATE + ") and invoice number is (" + FREE_TEXT+ ")$")
	public void the_date_is_(String invoiceDate, String invoiceNumber) throws ParseException {
		fixture = new InvoiceFeatureTestFixture();
		this.invoiceDate = invoiceDate;
		this.invoiceNumber = invoiceNumber;
	}

	@Given("^I have worked these weeks:$")
	public void I_have_worked_these_weeks(List<GivenWeek> givenWeeks) throws Throwable {
		for (GivenWeek givenWeek : givenWeeks) {
			fixture.collectInvoiceWeek(givenWeek.toWeek());
		}
	}

	@When("^the invoice is generated$")
	public void the_invoice_is_generated() throws Throwable {
		fixture.generateInvoice(invoiceDate, invoiceNumber);
	}

	@Then("^the gross amount for each week is calculated at:$")
	public void the_gross_amount_for_each_week_is_calculated_at(List<ThenWeek> thenWeeks) throws Throwable {
		for (ThenWeek thenWeek : thenWeeks) {
			assertEquals(thenWeek.getGrossAmount(), fixture.getGrossAmountForWeek(thenWeek.getWeekBeginning(), thenWeek.getWorkPlaceDescription()));
		}
	}
	
	@Then("^the sub-total is (" + MONEY_DECIMAL + ")$")
	public void the_sub_total_is_(String subTotal) throws Throwable {
		assertEquals(subTotal, fixture.getInvoiceSubTotal());
	}

	@Then("^the VAT is (" + MONEY_DECIMAL + ")$")
	public void the_VAT_is_(String vat) throws Throwable {
		assertEquals(vat, fixture.getInvoiceVat());
	}

	@Then("^the Total is ?(" + MONEY_DECIMAL + ")$")
	public void the_Total_is_(String total) throws Throwable {
		assertEquals(total, fixture.getInvoiceTotal());
	}
	
}
