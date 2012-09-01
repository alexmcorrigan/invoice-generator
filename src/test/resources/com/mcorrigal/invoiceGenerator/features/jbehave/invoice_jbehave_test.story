Scenario: Simple Invoice
	
Given an invoice date of 31/07/2012 and invoice number is NYSE-2012-07
And I have worked these weeks:
|week beginning |days worked |work place description |day rate   |
|02/07/2012     |5           |Tester                 |450.00     |
|09/07/2012     |5           |Tester                 |450.00     |
|16/07/2012     |5           |Tester                 |450.00     |
|23/07/2012     |5           |Tester                 |450.00     |
|30/07/2012     |2           |Tester                 |450.00     |
	
When the invoice is generated
	
Then the gross amount for each week is calculated at:
|week beginning |work place description |gross amount |
|02/07/2012     |Tester                 |2250.00      |
|09/07/2012     |Tester                 |2250.00      |
|16/07/2012     |Tester                 |2250.00      |
|23/07/2012     |Tester                 |2250.00      |
|30/07/2012     |Tester                 |900.00       |

And the sub-total is 9900.00
And the VAT is 1980.00
And the Total is 11880.00

Scenario: Invoice where one week contains more than one work placement

Given an invoice date of 31/07/2012 and invoice number is NYSE-2012-07
And I have worked these weeks:
|week beginning |days worked |work place description |day rate   |
|02/07/2012     |2           |Tester                 |450.00     |
|02/07/2012     |3           |Street Cleaner         |50.00      |
		
When the invoice is generated
		
Then the gross amount for each week is calculated at:
|week beginning |work place description |gross amount |
|02/07/2012     |Tester                 |900.00       |
|02/07/2012     |Street Cleaner         |150.00       |

And the sub-total is 1050.00
And the VAT is 210.00
And the Total is 1260.00