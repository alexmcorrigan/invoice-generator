package com.mcorrigal.invoiceGenerator;


public class InvoiceSum {

    private InvoiceAmount subTotal;
    private InvoiceAmount vat;
    private InvoiceAmount total;
	
    public InvoiceSum(InvoiceAmount subTotal, InvoiceAmount vat, InvoiceAmount total) {
		this.subTotal = subTotal;
		this.vat = vat;
		this.total = total;
	}

	public InvoiceAmount getSubTotal() {
		return subTotal;
	}

	public InvoiceAmount getVat() {
		return vat;
	}

	public InvoiceAmount getTotal() {
		return total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[subTotal=");
		builder.append(subTotal);
		builder.append(", vat=");
		builder.append(vat);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

}
