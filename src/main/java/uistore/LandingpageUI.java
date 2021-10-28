package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingpageUI {
	public WebDriver driver;

	public LandingpageUI(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchbox")
	WebElement searchbox;

	public WebElement search() {
		return searchbox;
	}

	@FindBy(xpath = "//*[contains(text(),'My Account')]")
	WebElement Myaccount;

	public WebElement MyAccount() {
		return Myaccount;
	}

}
