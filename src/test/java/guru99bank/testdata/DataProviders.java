package guru99bank.testdata;

import org.testng.annotations.DataProvider;

import guru99bank.constants.CommonConstants;

public class DataProviders {

	@DataProvider(name = "AddNewCustomer")
	public Object[][] AddNewCustomerTestData() {
		return new Object[][] { 
			{ "John Doe", "male", "1999-04-15", "address", "City", "State", "123456", "1234567890", "j" + CommonConstants.getDateTimeStamp() + "@email.com", "XfEs12*" }, 
		};
	}

	@DataProvider(name = "VerifyCustomer")
	public Object[][] VerifyCustomerTestData() {
		return new Object[][] { 
			{ "Jane Doe", "female", "1988-12-31", "address", "city", "State", "123456", "1234567890", "r" + CommonConstants.getDateTimeStamp() + "@email.com", "XfEs12*" }, 	
		};
	}

	@DataProvider(name = "AddNewAccount")
	public Object[][] AddNewAccountTestData() {
		return new Object[][] { 
			{ "21296", "Savings", "8000" }, 
		};
	}
}