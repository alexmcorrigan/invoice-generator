package com.mcorrigal.invoiceGenerator.features.shared;

import java.text.ParseException;

import com.mcorrigal.invoiceGenerator.InvoiceAmount;
import com.mcorrigal.invoiceGenerator.InvoiceDate;
import com.mcorrigal.invoiceGenerator.Week;
import com.mcorrigal.invoiceGenerator.WorkPlacement;

public class InvoiceFeatureTestObjects {
	
	public class GivenWeek {
		private String weekBeginning;
		private int daysWorked;
		private String workPlaceDescription;
		private String dayRate;
		
		public GivenWeek(
				String weekBeginning, 
				int daysWorked,
				String workPlaceDescription, 
				String dayRate) {
			this.weekBeginning = weekBeginning;
			this.daysWorked = daysWorked;
			this.workPlaceDescription = workPlaceDescription;
			this.dayRate = dayRate;
		}
		
		public Week toWeek() throws ParseException {
			return new Week(new InvoiceDate(weekBeginning), new WorkPlacement(workPlaceDescription, InvoiceAmount.create(dayRate)), daysWorked);
		}
	}
	
	public class ThenWeek {
		private String weekBeginning;
		private String workPlaceDescription;
		private String grossAmount;
		
		public ThenWeek(String weekBeginning, String workPlaceDescription, String grossAmount) {
			this.weekBeginning = weekBeginning;
			this.workPlaceDescription = workPlaceDescription;
			this.grossAmount = grossAmount;
		}
		
		public String getWeekBeginning() {
			return weekBeginning;
		}
		public String getWorkPlaceDescription() {
			return workPlaceDescription;
		}
		public String getGrossAmount() {
			return grossAmount;
		}
		
	}
	
}
