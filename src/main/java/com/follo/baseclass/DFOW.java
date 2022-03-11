package com.follo.baseclass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.function.Function;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



public class DFOW extends Baseclass {


	public static String	SpecSec1 = "//div/table/tbody/tr[";
	public static String	SpecSec2 = "]/td[3]/input";

	public static String	Dfow1 = "//div/table/tbody/tr[";
	public static String	Dfow2 = "]/td[4]/input";

	public static String DFOWdata = "C:\\Users\\ajithkumar.j\\Downloads\\follo_web_automation-master\\src\\main\\java\\com\\folloit\\excel\\DFOW_Data.xlsx";
	public static String SheetName = "DFOW";

	public static String fileloc = "C:\\Users\\ajithkumar.j\\Downloads\\DFOW_Import_Template_1646836289786.xlsx";

	public static void AddSpecificationSection() throws Throwable {

		Thread.sleep(3000);





		FileInputStream fin;
		fin = new FileInputStream(DFOWdata);

		XSSFWorkbook w= new XSSFWorkbook(fin);
		XSSFSheet s = w.getSheet(SheetName);
		int rowcount1 = s.getLastRowNum();


		for(int i =1; i<=rowcount1; i++)		{	


			WebElement SpecSec =	driver.findElement(By.xpath(SpecSec1 + i + SpecSec2));
			SpecSec.clear();

			SpecSec.sendKeys(s.getRow(i).getCell(0).toString());



			Click("AddRow", DFOWLocators);


		}


	}

	public static void AddDFOW() throws Throwable {

		Thread.sleep(3000);
		FileInputStream fin;
		fin = new FileInputStream(DFOWdata);

		XSSFWorkbook w= new XSSFWorkbook(fin);
		XSSFSheet s = w.getSheet(SheetName);
		int rowcount1 = s.getLastRowNum();


		for(int i =1; i<=rowcount1; i++)		{	
			Thread.sleep(2000);
			WebElement dfow =	driver.findElement(By.xpath(Dfow1 + i + Dfow2));

			dfow.sendKeys(s.getRow(i).getCell(1).toString());



		}

	}


	public static void DFOWlist() throws Throwable {

		StringSelection up = new StringSelection(fileloc);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(up, null);

		Robot upf = new Robot();
		upf.keyPress(KeyEvent.VK_CONTROL);
		upf.keyPress(KeyEvent.VK_V);
		upf.keyRelease(KeyEvent.VK_V);
		upf.keyRelease(KeyEvent.VK_CONTROL);
		upf.keyPress(KeyEvent.VK_ENTER);
		upf.keyRelease(KeyEvent.VK_ENTER);

	}



	public static void WaitForSuccess() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Updated Successfully.']"));
			}
		});
	}
	
	public static void BrowseFiles() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
			}
		});
	}
}
