package com.mcorrigal.invoiceGenerator;



public class Invoice {

    private InvoiceDate invoiceDate;
    private String invoiceNumber;
    private InvoiceWeekSet weeks;
    private InvoiceSum invoiceSum;

    public Invoice(
            InvoiceDate invoiceDate,
            String invoiceNumber,
            InvoiceWeekSet weeks,
            InvoiceSum invoiceSum) {

        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.weeks = weeks;
        this.invoiceSum = invoiceSum;
    }

    public InvoiceDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public InvoiceWeekSet getWeeks() {
        return weeks;
    }

    public InvoiceSum getInvoiceSum() {
        return invoiceSum;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("invoiceDate: " + invoiceDate.toLongString());
		builder.append(Constants.NEW_LINE);
		builder.append("invoiceNumber: " + invoiceNumber);
		builder.append(Constants.NEW_LINE);
		for (Week week : weeks) {
			builder.append(Constants.INDENT);
			builder.append(week.toString());
			builder.append(Constants.NEW_LINE);
		}
		builder.append("invoiceSum: " + invoiceSum.toString());
		builder.append(Constants.NEW_LINE);
		return builder.toString();
	}

    
}
