package com.mcorrigal.invoiceGenerator;


public class Week {

	private InvoiceDate weekBeginning;
	private WorkPlacement workPlacement;
	private int daysWorked;
	private InvoiceAmount grossAmount;

	public Week(
			InvoiceDate date, 
			WorkPlacement workPlacement, 
			int daysWorked) {
		
		this.weekBeginning = date;
		this.workPlacement = workPlacement;
		this.daysWorked = daysWorked;
		calculateAndSetGrossAmount();
	}

	private void calculateAndSetGrossAmount() {
		grossAmount = workPlacement.getDayRate().multiplyBy(daysWorked);
	}

	public InvoiceDate getWeekBeginning() {
		return weekBeginning;
	}

	public String getDescription() {
		return workPlacement.getDescription();
	}

	public int getDaysWorked() {
		return daysWorked;
	}

	public InvoiceAmount getGrossAmount() {
		return grossAmount;
	}

	@Override
	public String toString() {
		return "[weekBeginning=" + weekBeginning.toShortString() + ", description="
				+ workPlacement.getDescription() + ", daysWorked=" + daysWorked + ", dayRate="
				+ workPlacement.getDayRate() + ", grossAmount=" + grossAmount + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		Week that;
		try {
			that = (Week)o;
		} catch (Exception e) {
			return false;
		}
		if (that.getWeekBeginning().equals(this.weekBeginning) && that.workPlacement.equals(this.workPlacement)) {
			return true;
		} else {
			return false;
		}
		
	}

}
