package com.follo.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.assertj.core.api.ErrorCollector;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




import org.openqa.selenium.NoSuchElementException;




public class Baseclass {

	public static WebDriver driver;
	public static String properties;
	public static List<WebElement> ElementNames ;
	public static String Title;

	public static String AppProperties = "./src/test/java/com/follo/pagelocators/App.properties";
	public static String RegisterPageLocators = "./src/test/java/com/follo/pagelocators/AFollo_Register.properties";
	public static String LoginPageLocators = "./src/test/java/com/follo/pagelocators/Follo_01_Login.properties";
	public static String DFOWLocators = "./src/test/java/com/follo/pagelocators/Follo_02_DFOW.properties";



	public static String ExcelData = "./src/main/java/com/folloit/excel/Follo_WebApp_Datas.xlsx";

	public static String PropertyFile(String AppProperties , String locatorfile ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		return properties = Prop.getProperty(AppProperties);
	}


	public static void LaunchTheDriver(String Browser, String locator, String locatorfile ) throws Throwable {

		if(Browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome browser is launched");

			PropertyFile(locator, locatorfile);
			driver.get(properties);
		} 

		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("Firefox browser is launched");

			PropertyFile(locator, locatorfile);
			driver.get(properties);
		}


		else {
			System.out.println("Please try browser : Chrome or Firefox ");
		}


	}

	public static void WaitForTheElement(String Locator, String locatorfile) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile))).click();
	}


	public static void Waitfortheelement(String Locator, String locatorfile) throws Throwable {

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait C = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		C.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));


	}



	public static boolean softassert(String Condition1 , String Condition2) {
		
		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(Condition1).isEqualTo(Condition2);
		softAssertions.assertAll();
		return false;
	}
	
	
	public static WebElement getElement(String Locator, String locatorfile) throws Throwable {


		String EleType, Value;
		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);		
		EleType = Prop.getProperty(Locator).split(" ")[0];
		Value = Prop.getProperty(Locator).split(" ", 2)[1];
		switch (EleType) {
		case "id":
			WebDriverWait wait = new WebDriverWait(driver, 120);
			return	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(Value))));

		case "xpath":
			WebDriverWait wait1 = new WebDriverWait(driver, 120);
			return	wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Value))));

		default:
			WebDriverWait wait2 = new WebDriverWait(driver, 120);
			return	wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Value))));


		}
	}

	public static  List<WebElement> getElements(String Locator, String locatorfile) throws Throwable {


		String EleType, Value;
		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);		
		EleType = Prop.getProperty(Locator).split(" ")[0];
		Value = Prop.getProperty(Locator).split(" ", 2)[1];
		switch (EleType) {
		case "id":
			return ElementNames =  driver.findElements(By.id(Value));
		case "xpath":
			return ElementNames = driver.findElements(By.xpath(Value));
		default:
			return ElementNames = driver.findElements(By.xpath(Value));

		}

	}


	public static void MoveToElement(String Locator, String locatorfile ) throws Throwable {

		Actions action = new Actions(driver);

		action.moveToElement(getElement(Locator, locatorfile)).perform();

	}

	public static String ReadDataFrom(int row, int col, String sheetname) throws Throwable {


		File file = new File(ExcelData);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}

	public static void Click(String Locator,String locatorfile ) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile))).click();

	}


	public static void TypeDataInTheField ( String Locator,String locatorfile, String Data) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		Element.sendKeys(Data);
	} 


	//	public static void Click(String Locator, String locatorfile) throws Throwable {
	//
	//
	//		Wait C = new FluentWait<WebDriver>(driver)
	//				.withTimeout(Duration.ofSeconds(200))
	//				.pollingEvery(Duration.ofSeconds(10))
	//				.ignoring(NoSuchElementException.class);
	//
	//
	//		C.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));
	//		getElement(Locator, locatorfile).click();
	//
	//	}
	//
	//	public static void TypeDataInTheField ( String Locator,String locatorfile, String Data) throws Throwable {
	//
	//	
	//		getElement(Locator, locatorfile).sendKeys(Data);
	//	} 


	public static void SelectFromDropdown(String Locator,String locatorfile, String MobileCode) throws Throwable {

		Wait C = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(200))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);


		C.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));
		WebElement Code = 	getElement(Locator, locatorfile);

		Select PhoneCode = new Select(Code);
		PhoneCode.selectByValue(MobileCode);


	}

	public static void ScrollDown()throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}


	public static void ClickEnter()throws Throwable {
		Robot upf = new Robot();

		upf.keyPress(KeyEvent.VK_ENTER);

	}

	public static void ClickTab()throws Throwable {
		Robot upf = new Robot();

		upf.keyPress(KeyEvent.VK_TAB);


	}

	public static void ClickPageDown()throws Throwable {


		Robot upf = new Robot();


		upf.keyPress(KeyEvent.VK_PAGE_DOWN);

	}

	public static String GetText ( String Locator,String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		return Element.getText();
	} 


	public static void Clear (String Locator, String locatorfile ) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = 	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));

		element.clear();

	}
	
	public static String PageTitle () throws Throwable {

		Title = driver.getTitle();
		System.out.println("Page Title : " + Title);
		return Title;

	}
}
