package pageobject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import uistore.LandingpageUI;

public class MyAccount {

	WebDriver driver;

	// User defined constructor to initialize driver
	public MyAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on myaccount button and navigate to login page
	public WebDriver navigatetoacc() throws InterruptedException {
		// TODO Auto-generated method stub
		LandingpageUI lplocators = new LandingpageUI(driver);
		lplocators.MyAccount().click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> iter = id.iterator();
		Thread.sleep(2000);
		driver.switchTo().window(iter.next());
		return driver;
	}


}
