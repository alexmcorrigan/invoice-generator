package com.mcorrigal.invoiceGenerator;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

import com.mcorrigal.invoiceGenerator.Week;

public class WeekTest {

    @Test
    public void calculateGrossAmount() throws ParseException {
    	Week week = TestConstants.dummyWeek();
    	assertEquals("2500.00", week.getGrossAmount().toString());
    }


}
