package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.WebDriverHelper;
import uistore.LoginpageUI;
import uistore.SigninpageUI;

public class SignUp {

	WebDriver driver;

	public SignUp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Creating a new account by entering required credentials
	public WebDriver createaccount() throws InterruptedException {
		WebDriverHelper helper = new WebDriverHelper(driver);
		LoginpageUI loginpagelocator = new LoginpageUI(driver);
		SigninpageUI signinloc = new SigninpageUI(driver);
		loginpagelocator.createacc().click();
		helper.changetonewdriver();
		/*
		 * Set<String> id = driver.getWindowHandles(); Iterator<String> iter =
		 * id.iterator(); Thread.sleep(2000); driver.switchTo().window(iter.next());
		 */
		signinloc.firstname().sendKeys("Pooja");
		signinloc.lastname().sendKeys("Suresh");
		signinloc.emailid().sendKeys("pooja.adi2309@gmail.com");
		signinloc.getpassword().sendKeys("pooja");
		signinloc.getpasswordconfirm().sendKeys("pooja");
		signinloc.createacc().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
