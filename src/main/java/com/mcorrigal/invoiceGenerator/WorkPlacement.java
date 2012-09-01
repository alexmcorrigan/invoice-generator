package com.mcorrigal.invoiceGenerator;

public class WorkPlacement {

	private String description;
	private InvoiceAmount dayRate;
	
	public WorkPlacement(String description, InvoiceAmount dayRate) {
		this.description = description;
		this.dayRate = dayRate;
	}
	
	public String getDescription() {
		return description;
	}

	public InvoiceAmount getDayRate() {
		return dayRate;
	}
	
	@Override
	public boolean equals(Object o) {
		WorkPlacement that;
		try {
			that = (WorkPlacement)o;
		} catch (Exception e) {
			return false;
		}
		if (that.description.equals(this.description) && that.dayRate.equals(this.dayRate)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
