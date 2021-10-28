package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import uistore.LoginpageUI;

public class Login {
	WebDriver driver;

	// User defined constructor to initialize the driver
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Login Activity by sending credentials and click on login button

	public void login(String email, String password) {
		LoginpageUI loginpagelocator = new LoginpageUI(driver);
		loginpagelocator.getemail().clear();
		loginpagelocator.getpass().clear();
		loginpagelocator.getemail().sendKeys(email);
		loginpagelocator.getpass().sendKeys(password);
		// loginpagelocator.getemail().sendKeys("pooja.adi2309@gmail.com");
		// loginpagelocator.getpass().sendKeys("password123");
		loginpagelocator.signin().click();
	}

}
