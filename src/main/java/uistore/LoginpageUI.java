package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageUI {
	public WebDriver driver;

	public LoginpageUI(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement email;

	public WebElement getemail() {
		return email;
	}

	@FindBy(id = "pass")
	WebElement pass;

	public WebElement getpass() {
		return pass;
	}

	@FindBy(id = "send2")
	WebElement signin;

	public WebElement signin() {
		return signin;
	}

	@FindBy(xpath = "//*[contains(text(),'Create an Account')]")
	WebElement createacc;

	public WebElement createacc() {
		return createacc;
	}

}
