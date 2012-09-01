package com.mcorrigal.invoiceGenerator;

import java.math.BigDecimal;

public class InvoiceAmount {

	public static final InvoiceAmount ZERO = InvoiceAmount.create("0");
	public static final InvoiceAmount ONE_HUNDRED = InvoiceAmount.create("100");
	
	private BigDecimal amount;
	
	public static InvoiceAmount create(String amountString) {
		return new InvoiceAmount(NumberUtils.makeDecimal(amountString));
	}
	
	public static InvoiceAmount create(BigDecimal amountDecimal) {
		return new InvoiceAmount(amountDecimal);
	}
	
	private InvoiceAmount(BigDecimal amount) {
		this.amount = round(amount);
	}
	
	private BigDecimal round(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public String toString() {
		return amount.toString();
	}

	public InvoiceAmount multiplyBy(int factor) {
		return InvoiceAmount.create(amount.multiply(new BigDecimal(factor)));
	}

	public InvoiceAmount add(InvoiceAmount value) {
		return InvoiceAmount.create(amount.add(value.amount));
	}

	public InvoiceAmount divideBy(InvoiceAmount divisor) {
		return InvoiceAmount.create(amount.divide(divisor.amount, 3, BigDecimal.ROUND_HALF_UP));
	}

	public InvoiceAmount multiplyBy(InvoiceAmount factor) {
		return InvoiceAmount.create(amount.multiply(factor.amount));
	}
	
	@Override
	public boolean equals(Object o) {
		InvoiceAmount that;
		try {
			that = (InvoiceAmount)o;
		} catch (Exception e) {
			return false;
		}
		if (that.amount.equals(this.amount)) {
			return true;
		} else {
			return false;
		}
	}
	
}
