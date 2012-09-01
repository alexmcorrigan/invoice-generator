package com.mcorrigal.invoiceGenerator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class InvoiceWeekSet implements Iterable<Week> {

	private List<Week> weeks;
	
	public InvoiceWeekSet() {
		weeks = new ArrayList<Week>();
	}
	
	public boolean add(Week week) {
		if (!contains(week)) {
			weeks.add(week);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Week week) {
		for (Week existingWeek : weeks) {
			if (existingWeek.equals(week)) return true;
		}
		return false;
	}

	public int size() {
		return weeks.size();
	}

	@Override
	public Iterator<Week> iterator() {
		return weeks.iterator();
	}

	public boolean containsWeekWith(String weekBeginDate, String workPlaceDescription) throws ParseException {
		for (Week week : weeks) {
			if (week.getWeekBeginning().equals(new InvoiceDate(weekBeginDate)) && week.getDescription().equals(workPlaceDescription)) return true;
		}
		return false;
	}
	
	public Week getWeekFor(String weekBeginDate, String workPlaceDescription) throws ParseException {
		for (Week week : weeks) {
			if (week.getWeekBeginning().equals(new InvoiceDate(weekBeginDate)) && week.getDescription().equals(workPlaceDescription)) return week;
		}
		throw new NoSuchElementException("No week found with Begin Date:" + weekBeginDate + " and Description: " + workPlaceDescription);
	}
}
