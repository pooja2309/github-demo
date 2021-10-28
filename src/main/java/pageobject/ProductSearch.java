package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import uistore.LandingpageUI;
import uistore.ProductpageUI;
import utility.Extentreports;

public class ProductSearch {
	WebDriver driver;

	// User defined constructor to initialize driver
	public ProductSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	ArrayList<String> productlist = new ArrayList<String>();

//Search for products in the array list and add some books to cart 
	public void searchforproducts(Extentreports er) throws InterruptedException {
		// TODO Auto-generated method stub
		Iterator<String> name = productlist.iterator();

		LandingpageUI lplocators = new LandingpageUI(driver);
		ProductpageUI prodlocators = new ProductpageUI(driver);
		Addtocart ac = new Addtocart(driver, er);
		while (name.hasNext()) {
			String product = name.next();
			lplocators.search().sendKeys(product);
			lplocators.search().sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			er.startTest("product search");

			if (product.equalsIgnoreCase("cat")) {
				ac.addcatbook(prodlocators);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} else if (product.equalsIgnoreCase("gmat")) {
				ac.addgmatbook(prodlocators);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}

			lplocators.search().clear();
			er.endTest();
		}
	}

	// To fetch the products mentioned in the excel sheet and store in array list
	public void getproducts(String path) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		int number_of_sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < number_of_sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row frow = rows.next(); // first row
				Iterator<Cell> cols = frow.cellIterator();
				int k = 0;
				int colnum = 0;
				while (cols.hasNext()) {
					Cell value = cols.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						colnum = k;
					}
					k++;
				}
				System.out.println("Column number: " + colnum);
				while (rows.hasNext()) {
					Row r = rows.next();
					System.out.println(r.getCell(colnum).getStringCellValue());
					productlist.add(r.getCell(colnum).getStringCellValue());

				}
			}
			workbook.close();
		}
	}
}
