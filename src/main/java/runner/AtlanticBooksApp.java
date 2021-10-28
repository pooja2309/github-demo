package runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.Login;
import pageobject.MyAccount;
import pageobject.ProductSearch;
import pageobject.SignUp;
import reusablecomponents.WebDriverHelper;
import utility.Extentreports;
import utility.Readproperty;

public class AtlanticBooksApp {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	Extentreports er;
	private static Logger log = LogManager.getLogger(AtlanticBooksApp.class.getName());

	// Sets the chrome driver by fetching info from config.properties
	@Test
	public void setdriver() {
		String browser = rp.getdriver();
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			helper = new WebDriverHelper(driver);
			log.info("getting browser name");

		}
	}

	// Opens the Book store url in chrome browser
	@Test(dependsOnMethods = { "setdriver" })
	public void openwebsite() {
		String url = rp.getUrl();
		helper.openwebsite(url);
		log.info("setting chrome driver");
	}

	// Retrieves the excel sheet data and performs search
	@Test(dependsOnMethods = { "openwebsite" })
	public void performtest() throws IOException, InterruptedException {
		String path = System.getProperty("user.dir") + rp.pathsheet();
		ProductSearch ps = new ProductSearch(driver);
		Thread.sleep(2000);
		er = new Extentreports(driver);
		er.startTest("searching products");
		ps.getproducts(path);
		ps.searchforproducts(er);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
		log.info("searched products");
	}

	// Navigates to My Account - Login page
	@Test(dependsOnMethods = { "performtest" })
	public void clickonmyaccount() throws InterruptedException {
		er.startTest("navigating to my account");
		MyAccount acc = new MyAccount(driver);
		driver = acc.navigatetoacc();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
		log.info("navigating to account");
	}

	// Testing Login
	@Test(dataProvider = "getCredentials", dependsOnMethods = { "clickonmyaccount" })
	public void login(String email, String password) {
		er.startTest("login");
		Login login = new Login(driver);
		login.login(email, password);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
		log.info("Login");
	}

	@DataProvider
	public Object[][] getCredentials() {
		Object[][] data = new Object[2][2];
		data[0][0] = "pooja.adi2309@gmail.com";
		data[0][1] = "password123";
		data[1][0] = "emailid2@gmail.com";
		data[1][1] = "password123";
		return data;
	}

	// Testing Signup
	@Test(dependsOnMethods = { "login" })
	public void signup() throws InterruptedException {
		er.startTest("signup");
		SignUp create = new SignUp(driver);
		driver = create.createaccount();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		log.info("Signup");
	}

	// Closure
	@AfterTest
	public void close() {
		log.info("Closure");
		driver.close();
	}

}
