package guru99bank.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import guru99bank.listeners.ReportListeners;

public class ManagerHomePage {
    
	public WebDriver driver;

	@FindBy(xpath = "//marquee[@class='heading3']")
	WebElement welcomeText;

	@FindBy(xpath = "//td[contains(text(), 'Manger Id :')]")
	WebElement managerId;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement lnkLogout;

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement lnkNewCustomer;

	@FindBy(xpath = "//a[text()='New Account']")
	WebElement lnkNewAccount;

	public ManagerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private void log(Status status, String message) {
	    if (ReportListeners.test != null) {
	        ReportListeners.test.log(status, message);
	    }
	}
	
	public boolean isWelcomeTextPresent() {
    	try {
			ReportListeners.test.log(Status.PASS, "Welcome message displayed.");
			System.out.println("Welcome message displayed.");
			return welcomeText.isDisplayed();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Welcome message not displayed. Exception occured : " + e);
			System.out.println("Welcome message not displayed. Exception occured : " + e);
			return false;
		}
	}

	public String getWelcomeMessage() {
    	try {
			ReportListeners.test.log(Status.PASS, "Welcome message is : " + welcomeText.getText());
			System.out.println("Welcome message is : " + welcomeText.getText());
			return welcomeText.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get welcome message. Exception occured : " + e);
			System.out.println("Unable to get welcome message. Exception occured : " + e);
			return "";
		}
	}

	public String getPageTitle() {
    	try {
			ReportListeners.test.log(Status.PASS, "Page title is : " + driver.getTitle());
			System.out.println("Page title is : " + driver.getTitle());
			return driver.getTitle();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get page title. Exception occured : " + e);
			System.out.println("Unable to get page title. Exception occured : " + e);
			return "";
		}
	}

	public String getManagerId() {
    	try {
			ReportListeners.test.log(Status.PASS, "Manager Id is : " + managerId.getText());
			System.out.println("Manager Id is : " + managerId.getText());
			return managerId.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Managers Id. Exception occured : " + e);
			System.out.println("Unable to get Managers Id. Exception occured : " + e);
			return "";
		}
	}

	public LoginPage clickLogout() {
    	try {
			lnkLogout.click();
			ReportListeners.test.log(Status.PASS, "Clicked on 'Logout' menu link.");
			System.out.println("Clicked on 'Logout' menu link.");
			return new LoginPage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Error occured while clicking on the 'Logout' menu link. Exception occured : " + e);
			System.out.println("Error occured while clicking on the 'Logout' menu link. Exception occured : " + e);
			return null;
		}
	}

	public AddCustomerPage clickAddCustomer() {
    	try {
			lnkNewCustomer.click();
			ReportListeners.test.log(Status.PASS, "Clicked on 'New Customer' menu link.");
			System.out.println("Clicked on 'New Customer' menu link.");
			return new AddCustomerPage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Error occured while clicking on the 'New Customer' menu link. Exception occured : " + e);
			System.out.println("Error occured while clicking on the 'New Customer' menu link. Exception occured : " + e);
			return null;
		}
	}

	public AddAccountPage clickAddAccount() {
    	try {
			lnkNewAccount.click();
			ReportListeners.test.log(Status.PASS, "Clicked on 'New Account' menu link.");
			System.out.println("Clicked on 'New Account' menu link.");
			return new AddAccountPage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Error occured while clicking on the 'New Account' menu link. Exception occured : " + e);
			System.out.println("Error occured while clicking on the 'New Account' menu link. Exception occured : " + e);
			return null;
		}
	}

}
