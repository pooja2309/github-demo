package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import uistore.ProductpageUI;
import utility.Extentreports;

public class Addtocart {
	WebDriver driver;
	Extentreports er;

	// User defined Constructor
	public Addtocart(WebDriver driver, Extentreports er) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}

	// Adding CAT book to cart
	public void addcatbook(ProductpageUI prodlocators) throws InterruptedException {
		er.startTest("Adding CAT Book to Cart");
		prodlocators.addcatbook().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.endTest();
	}

	// Adding GMAT book to cart
	public void addgmatbook(ProductpageUI prodlocators) throws InterruptedException {
		er.startTest("Adding GMAT Book to Cart");
		prodlocators.addgmatbook().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.endTest();
	}

}
