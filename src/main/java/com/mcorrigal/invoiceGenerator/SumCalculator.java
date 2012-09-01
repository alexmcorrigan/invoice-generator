package com.mcorrigal.invoiceGenerator;


public class SumCalculator {

	private final InvoiceAmount vatRate;
	
	public SumCalculator(InvoiceAmount vatRate) {
		this.vatRate = vatRate;
	}
	
	public InvoiceSum calculate(InvoiceWeekSet weeks) {
		InvoiceAmount subTotal = sumGrossAmounts(weeks);
		InvoiceAmount vat = calculateVat(subTotal);
		InvoiceAmount total = subTotal.add(vat);
		return new InvoiceSum(subTotal, vat, total);
	}
	
	private InvoiceAmount sumGrossAmounts(InvoiceWeekSet weeks) {
		InvoiceAmount sum = InvoiceAmount.ZERO;
		for (Week week : weeks) {
			sum = sum.add(week.getGrossAmount());
		}
		return sum;
	}
	
	private InvoiceAmount calculateVat(InvoiceAmount value) {
		return value.divideBy(InvoiceAmount.ONE_HUNDRED).multiplyBy(vatRate);
	}
	
}
