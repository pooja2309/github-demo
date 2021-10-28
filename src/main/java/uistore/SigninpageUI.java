package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninpageUI {
	public WebDriver driver;

	public SigninpageUI(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Create an Account')]")
	WebElement createacc;

	public WebElement createacc() {
		return createacc;
	}

	@FindBy(id = "firstname")
	WebElement fname;

	public WebElement firstname() {
		return fname;
	}

	@FindBy(id = "lastname")
	WebElement lname;

	public WebElement lastname() {
		return lname;
	}

	@FindBy(id = "email_address")
	WebElement emailtocreateacc;

	public WebElement emailid() {
		return emailtocreateacc;
	}

	@FindBy(id = "password")
	WebElement password;

	public WebElement getpassword() {
		return password;
	}

	@FindBy(id = "password-confirmation")
	WebElement passwordconfirm;

	public WebElement getpasswordconfirm() {
		return passwordconfirm;
	}

}
