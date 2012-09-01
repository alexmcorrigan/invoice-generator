package com.mcorrigal.invoiceGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InvoiceDate {

	private static final SimpleDateFormat LONG_DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
	private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	private Calendar cal;
	
	public InvoiceDate(Calendar cal) {
		this.cal = cal;
	}
	
	public InvoiceDate(String shortDateString) throws ParseException {
		cal = Calendar.getInstance();
		cal.setTime(SHORT_DATE_FORMAT.parse(shortDateString));
	}
	
	public String toLongString() {
		return LONG_DATE_FORMAT.format(cal.getTime());
	}

	public String toShortString() {
		return SHORT_DATE_FORMAT.format(cal.getTime());
	}
	
	public boolean equals(InvoiceDate invoiceDate) {
		if (this.cal.equals(invoiceDate.cal)) {
			return true;
		} else {
			return false;
		}
	}
	
}
