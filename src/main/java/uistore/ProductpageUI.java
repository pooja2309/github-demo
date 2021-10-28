package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductpageUI {
	public WebDriver driver;

	public ProductpageUI(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'₹1,390.00')]//following::button")
	WebElement gmatbook;

	public WebElement addgmatbook() {
		return gmatbook;
	}

	@FindBy(xpath = "//*[contains(text(),'₹1,532.00')]//following::button")
	WebElement catbook;

	public WebElement addcatbook() {
		return catbook;
	}

	@FindBy(xpath = "//*[contains(text(),'₹2,044.00')]//following::button")
	WebElement satbook;

	public WebElement addsatbook() {
		return satbook;
	}

	@FindBy(xpath = "//*[contains(text(),'₹412.00')]//following::button")
	WebElement ntsebook;

	public WebElement addntsebook() {
		return ntsebook;
	}

	@FindBy(xpath = "//*[contains(text(),'₹1,645.00')]//following::button")
	WebElement gatebook;

	public WebElement addgatebook() {
		return gatebook;
	}
}
