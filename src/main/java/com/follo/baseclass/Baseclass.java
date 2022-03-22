package com.follo.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.asserts.SoftAssert;



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
	public static String CompaniesLocators = "./src/test/java/com/follo/pagelocators/Follo_03_Companies.properties";
	


	public static void Click(String Locator,String locatorfile ) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile))).click();

	}

	public static void TypeDataInTheField ( String Locator,String locatorfile, String Data) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		Element.sendKeys(Data);
	} 

	public static void SelectFromDropdown(String Locator,String locatorfile, String MobileCode) throws Throwable {

		Wait waits = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(200))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);


		waits.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));
		WebElement Code = 	getElement(Locator, locatorfile);

		Select PhoneCode = new Select(Code);
		PhoneCode.selectByValue(MobileCode);


	}


	public static void ScrollDown()throws Throwable {

		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	
	public static void MoveToElement(String Locator, String locatorfile ) throws Throwable {

		Actions action = new Actions(driver);

		action.moveToElement(getElement(Locator, locatorfile)).perform();

	}

	public static void ClickEnter()throws Throwable {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public static void ClickTab()throws Throwable {
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);


	}

	public static void ClickPageDown()throws Throwable {


		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

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

	}	public static String GetAttr ( String Locator,String locatorfile, String Attribute) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		return Element.getAttribute(Attribute);
	} 

	public static String PageTitle () throws Throwable {

		Title = driver.getTitle();
		return Title;

	}

	public static String PropertyFile(String AppProperties , String locatorfile ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		return properties = Prop.getProperty(AppProperties);
	}

	public static void Print(String PrintValue) throws Throwable {

		System.out.println(PrintValue);


	}
	public static void PrintError(String PrintValue) throws Throwable {

		System.err.println(PrintValue);


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

	public static void Clicks(String Locator, String locatorfile) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile))).click();
	}

	public static WebElement WaitForTheElement(String Locator, String locatorfile) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
	}


	public static void Waitfortheelement(String Locator, String locatorfile) throws Throwable {


		Wait waits = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		waits.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));


	}

	public static void Wait(int Wait) throws Throwable {

		Thread.sleep(Wait);

	}

	public static WebElement FindElement(String locator, int i, String locators) throws Throwable {

		return driver.findElement(By.xpath(locator + i + locators));
	}

	public static WebElement FindTheElement(String locator) throws Throwable {

		return driver.findElement(By.xpath(locator));
	}

	public static boolean softassert(String OriginalValue , String ExpectedValue) {

		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(OriginalValue, ExpectedValue);
		softassert.assertAll();
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
			WebDriverWait id = new WebDriverWait(driver, 120);
			return	id.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(Value))));

		case "xpath":
			WebDriverWait xpath = new WebDriverWait(driver, 120);
			return	xpath.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Value))));
		case "css":
			WebDriverWait css = new WebDriverWait(driver, 120);
			return	css.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(Value))));
		case "tag":
			WebDriverWait tag = new WebDriverWait(driver, 120);
			return	tag.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName(Value))));
		case "partialText":
			WebDriverWait partialText = new WebDriverWait(driver, 120);
			return	partialText.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(Value))));
		case "linkText":
			WebDriverWait linkText = new WebDriverWait(driver, 120);
			return	linkText.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(Value))));
		case "name":
			WebDriverWait name = new WebDriverWait(driver, 120);
			return	name.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(Value))));
		case "className":
			WebDriverWait className = new WebDriverWait(driver, 120);
			return	className.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(Value))));



		default:
			WebDriverWait defaultvalue = new WebDriverWait(driver, 120);
			return	defaultvalue.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Value))));


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
		case "css":

			return ElementNames =driver.findElements(By.cssSelector(Value));
		case "tag":

			return ElementNames =driver.findElements(By.tagName(Value));

		case "partialText":
			return ElementNames =driver.findElements(By.partialLinkText(Value));

		case "linkText":
			return ElementNames =driver.findElements(By.linkText(Value));

		case "name":
			return ElementNames =driver.findElements(By.name(Value));

		case "className":
			return ElementNames =driver.findElements(By.className(Value));



		default:
			return ElementNames = driver.findElements(By.xpath(Value));


		}

	}



}
