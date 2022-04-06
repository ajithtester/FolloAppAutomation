package com.follo.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
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

import com.follo.excel.read.ReadFrom;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Baseclass {

	public static WebDriver driver;
	public static String properties;
	public static List<WebElement> ElementNames ;
	public static String Title;

	public static String AppProperties = "./src/test/resources/PropertiesFile/App.properties";
	public static String RegisterPageLocators = "./src/test/resources/PropertiesFile/Follo_01_Register.properties";
	public static String LoginPageLocators = "./src/test/resources/PropertiesFile/Follo_02_Login.properties";
	public static String DFOWLocators = "./src/test/resources/PropertiesFile/Follo_03_DFOW.properties";
	public static String CompaniesLocators = "./src/test/resources/PropertiesFile/Follo_04_Companies.properties";
	public static String MembersLocators = "./src/test/resources/PropertiesFile/Follo_05_Members.properties";
	public static String GateLocators = "./src/test/resources/PropertiesFile/Follo_06_Gate.properties";
	public static String EquipmentLocators = "./src/test/resources/PropertiesFile/Follo_07_Equipment.properties";
	public static String DeliveryCalendarLocators = "./src/test/resources/PropertiesFile/Follo_08_DeliveryCalendar.properties";


	public static void Click(String Locator,String locatorfile ) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile))).click();

	}

	public static boolean IsEqual(String ActualValue, String ExpectedValue ) throws Throwable {

		return ActualValue.equalsIgnoreCase(ExpectedValue);

	}

	public static boolean IsElementDisplayed(String Locator,String locatorfile ) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement ElementDisplay =  wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		return ElementDisplay.isDisplayed();
	}

	public static void TypeDataInTheField ( String Locator,String locatorfile, String Data) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		Element.sendKeys(Data);
	} 



	public static void SelectFromDropdown(String Locator,String locatorfile, String Value) throws Throwable {

		Wait waits = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(200))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);


		waits.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));
		WebElement Code = 	getElement(Locator, locatorfile);

		Select PhoneCode = new Select(Code);
		PhoneCode.selectByValue(Value);


	}

	public static void SelectFromVisibleText(String Locator,String locatorfile, String Value) throws Throwable {

		Wait waits = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(200))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);


		waits.until(ExpectedConditions.elementToBeClickable(getElement(Locator, locatorfile)));
		WebElement Code = 	getElement(Locator, locatorfile);

		Select PhoneCode = new Select(Code);
		PhoneCode.selectByVisibleText(Value);


	}

	public static void SelectFromDropdown(String Locator, String Locator2 , int i, String Value) throws Throwable {


		WebElement Code = 	FindElement(Locator, Locator2 , i );

		Select PhoneCode = new Select(Code);
		PhoneCode.selectByVisibleText(Value);


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
	
	public static void ClickPageUp()throws Throwable {


		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);

	}

	public static String GetText ( String Locator,String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator,locatorfile)));
		return Element.getText();
	} 

	public static void Clear (WebElement Locator ) throws Throwable {

		Locator.clear();
	}

	public static void EnterValueInTheElement (WebElement Locator , String Value ) throws Throwable {

		Locator.sendKeys(Value);

	}

	public static int SizeOfTheList (String Locator , String LocatorFile ) throws Throwable {

		ElementNames = 	getElements(Locator, LocatorFile);
		int rowcount = 	ElementNames.size();
		return rowcount;

	}

	public static  String GetTextFromTheElement (WebElement Locator ) throws Throwable {

		return Locator.getText();

	}

	public static String GetAttributeFromTheElement (WebElement Locator) throws Throwable {

		return Locator.getAttribute("value");

	}

	public static void Click(WebElement Locator) throws Throwable {

		Locator.click();

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

	//	public static WebElement FindElement(String locator, int i, String locators) throws Throwable {
	//
	//		return driver.findElement(By.xpath(locator + i + locators));
	//	}

	public static WebElement FindElement(String Locator, String LocatorsFile,  int i ) throws Throwable {
		String Xpath =	PropertyFile(Locator, LocatorsFile);
		return driver.findElement(By.xpath(Xpath + "[" + i + "]"));
	}

	public static WebElement FindTheElement(String locator) throws Throwable {

		return driver.findElement(By.xpath(locator));
	}

	public static int GetSize(String Locator, String locatorfile) throws Throwable {

		List<WebElement> Element = 	getElements(Locator, locatorfile);
		int Size =	Element.size();
		return Size;
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//Newly added
	//Get Locators type
	public static WebElement getlocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatortype = split[0];
		String locatorvalue = split[1];

		if (locatortype.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorvalue));
		else if (locatortype.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorvalue));
		else if (locatortype.toLowerCase().equals("classname") || (locatortype.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("tagname") || (locatortype.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("linktext") || (locatortype.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorvalue));
		else if (locatortype.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorvalue));
		else if ((locatortype.toLowerCase().equals("cssselector")) || (locatortype.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorvalue));
		else if (locatortype.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorvalue));
		else
			throw new Exception("Unknown locator type '" + locatortype + "'");
	}
	//List of webelement locators
	public static List<WebElement> getlocatorss(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatortype = split[0];
		String locatorvalue = split[1];

		if (locatortype.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorvalue));
		else if (locatortype.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorvalue));
		else if (locatortype.toLowerCase().equals("classname") || (locatortype.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("tagname") || (locatortype.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("linktext") || (locatortype.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorvalue));
		else if (locatortype.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorvalue));
		else if ((locatortype.toLowerCase().equals("cssselector")) || (locatortype.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorvalue));
		else if (locatortype.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorvalue));
		else
			throw new Exception("Unknown locator type '" + locatortype + "'");
	}

	//	public static List<WebElement> getwebElements(String locator) throws Exception {
	//		//return getlocatorss(Repository.getProperty(locator));
	//	}
	//
	//	public WebElement getwebElement(String locator) throws Exception {
	//
	//		return getlocators(Repository.getProperty(locator));
	//	}

	//Explicit Wait methods
	public static void explicitwaitclickable(WebElement ele) {


		WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void Stale(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
	}

	public void explicitwaitvisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void explicitwaitvisibletolocate(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	public void explicitwaitelementclickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// select the DropDown By VisibleText
	public void selectDropDownByVisible(WebElement element, String dropDownValue) {
		Select select = new Select(element);
		select.selectByVisibleText(dropDownValue);
	}

	// select the DropDown By Index
	public void selectDropDownByIndex(WebElement element, int dropDownValue) {
		Select select = new Select(element);
		select.selectByIndex(dropDownValue);
	}

	// select the DropDown By Value
	public void selectDropDownByValue(WebElement element, String dropDownValue) {
		Select select = new Select(element);
		select.selectByValue(dropDownValue);
	}

	// To get all list of values from the DropDown using TagName
	public static List<WebElement> getElementsByTagName(WebElement element, String optionName) {
		List<WebElement> listOfElements = element.findElements(By.tagName(optionName));
		if (listOfElements.size() != 0)
			return listOfElements;
		else
			return null;
	}

	// Waits for element to be present
	public boolean isElementPresent(WebDriver driver, By element) {
		boolean presenceFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.wait(1000);
			presenceFlag = true;
		} catch (Exception e) {
			System.out.println("Exception is Element Is not Present");
		}
		return presenceFlag;
	}

	// select Radio Button
	public void selectTheRadioButton(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Checkbox: " + element + "is already selected");
			} else {
				// Select the checkbox
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to select the checkbox: " + element);
		}

	}

	// Dselect the RadioButton
	public void deSelectTheRadioButton(WebElement element) {
		try {
			if (element.isSelected()) {
				// De-select the checkbox
				element.click();
			} else {
				System.out.println("Checkbox: " + element + "is already deselected");
			}
		} catch (Exception e) {
			System.out.println("Unable to deselect checkbox: " + element);
		}
	}

	// select the CheckBox
	public void selectTheCheckbox(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Checkbox: " + element + "is already selected");
			} else {
				// Select the checkbox
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to select the checkbox: " + element);
		}

	}

	// Dselect the CheckBox
	public void deSelectTheCheckbox(WebElement element) {
		try {
			if (element.isSelected()) {
				// De-select the checkbox
				element.click();
			} else {
				System.out.println("Checkbox: " + element + "is already deselected");
			}
		} catch (Exception e) {
			System.out.println("Unable to deselect checkbox: " + element);
		}
	}

	// Accepting the Alert with the AlertMessage
	public void AcceptAlert() {
		Alert element = driver.switchTo().alert();
		String alertText = element.getText();
		System.out.println(alertText);
		element.accept();
	}

	// Dismissing the Alert with the AlertMessage
	public void DissmissAlert() {
		Alert element = driver.switchTo().alert();
		String alertText = element.getText();
		System.out.println(alertText);
		element.dismiss();
	}

	// Hover and Click
	public static void MouseOver(WebElement element) {
		try {

			Actions actions = new Actions(driver);

			actions.moveToElement(element).click().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Double click on an Element
	public static void doubleClick(WebElement element) {
		try {
			Actions action = new Actions(driver).doubleClick(element);
			action.build().perform();

			System.out.println("Double clicked the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}
	}

	// Drag and Drop the Element
	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement
					+ "is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
		}
	}

	// Switching Windows
	public void switchToWindow(WebDriver driver, int Index) {
		try {
			Set<String> Allwindows = driver.getWindowHandles();
			String windowselect = (String) Allwindows.toArray()[Index];
			driver.switchTo().window(windowselect);
		} catch (Exception e) {
			System.out.println("Exception While switching the windows");
		}
	}

	// Switches to the frame using by Frame Id
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame + e.getStackTrace());
		}
	}

	// Switches to the frame using Frame Name
	public void switchToFrame(String frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with name " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame + e.getStackTrace());
		}
	}

	// Switches to the frame using Frame Element
	public void switchToFrame(WebElement frameElement) {
		try {
			if (isElementPresent(frameElement)) {
				driver.switchTo().frame(frameElement);
				System.out.println("Navigated to frame with element " + frameElement);
			} else {
				System.out.println("Unable to navigate to frame with element " + frameElement);
			}
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + frameElement + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			System.out.println(
					"Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
		}
	}

	private boolean isElementPresent(WebElement frameElement) {
		// TODO Auto-generated method stub
		return false;
	}

	// Switches to the frame using Frame Inside Frame (Multiple Frame)
	public void switchToFrame(String ParentFrame, String ChildFrame) {
		try {
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			System.out.println("Navigated to innerframe with id " + ChildFrame + "which is present on frame with id"
					+ ParentFrame);
		} catch (NoSuchFrameException e) {
			System.out
			.println("Unable to locate frame with id " + ParentFrame + " or " + ChildFrame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame + e.getStackTrace());
		}
	}

	// Switch back to the Default Webpagepage after frame.
	public void switchtoDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
		} catch (Exception e) {
			System.out.println("unable to navigate back to main webpage from frame" + e.getStackTrace());
		}
	}

	//Scroll down
	public void fullScroll() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}





}
