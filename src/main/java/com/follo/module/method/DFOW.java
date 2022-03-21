package com.follo.module.method;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



public class DFOW extends Baseclass {


	public static String	SpecSec1 = "//div/table/tbody/tr[";
	public static String	SpecSec2 = "]/td[3]/input";

	public static String	Dfow1 = "//div/table/tbody/tr[";
	public static String	Dfow2 = "]/td[4]/input";

	public static  String   delete = "//div/table/tbody/tr[";
	public static  String   delete1 = "]/td[5]/ul/li/img";







	public static void AddDFOW() throws Throwable {

		Wait(3000);

		ReadFrom.DynamicExcel(ReadFrom.AddDFOW);

		try {
			for(int i =1; i<=ReadFrom.rowcount; i++)		{	

				WebElement SpecSec = 	FindElement(SpecSec1, i, SpecSec2);

				SpecSec.clear();

				SpecSec.sendKeys(ReadFrom.Sheet.getRow(i).getCell(0).toString());
				Print("SpecSec is entered as : " + ReadFrom.Sheet.getRow(i).getCell(0).toString());

				Click("AddRow", DFOWLocators);

			}

			Wait(3000);

			for(int i =1; i<=ReadFrom.rowcount; i++)		{	
				Wait(2000);
				WebElement dfow =	FindElement(Dfow1, i, Dfow2);
				dfow.clear();

				dfow.sendKeys(ReadFrom.Sheet.getRow(i).getCell(1).toString());
				Print("Dfow is entered as : " + ReadFrom.Sheet.getRow(i).getCell(1).toString());



			}
		}
		catch (Exception e) {
			Print(e.getMessage());
		}


	}

	public static void SearchDFOW() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchDFOW);
//
//
	Print("eXCEL : " + ReadFrom.rowcount);

		try {

			for(int j =1; j<=ReadFrom.rowcount; j++)	{

				TypeDataInTheField("SearchDfow", DFOWLocators, ReadFrom.Excel(j, 0, ReadFrom.SearchDFOW));
				ClickEnter();
				Wait(6000);

				ElementNames = 	getElements("DFOWlist", DFOWLocators);
				int rowcount = 	ElementNames.size();
				Print("No of dfow displayed : " + rowcount);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Dfow =	FindElement(Dfow1 , i , Dfow2);
					String DFOWname =	Dfow.getAttribute("value");

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(j, 0, ReadFrom.SearchDFOW);

					if(DFOWname.equalsIgnoreCase(SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + DFOWname);
						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + DFOWname);
					}
					
					
				}
				Click("ClearSearch", DFOWLocators);
				Wait(3000);
			//	Clear("SearchDfow", DFOWLocators);
			
		}
		}
		catch (Exception e) {
			Print(e.getMessage());
		}
	}


	public static void EditDFOW() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditDFOW);


		Print("eXCEL : " + ReadFrom.rowcount);

		try {

			for(int j =1; j<=ReadFrom.rowcount; j++)	{

				ElementNames = 	getElements("DFOWlist", DFOWLocators);
				int rowcount = 	ElementNames.size();
				Print("No of elements : " + rowcount);

				for(int i =1; i<=rowcount; i++)		{

					WebElement SpecSec =	FindElement(SpecSec1, i , SpecSec2);

					String Specificaiton = 	SpecSec.getAttribute("value");


					WebElement Dfow =	FindElement(Dfow1 , i , Dfow2);
					String DFOWname =	Dfow.getAttribute("value");

					Wait(2000);

					String ToEdit = Specificaiton + DFOWname;


					String EditIt =	ReadFrom.Excel(j, 0, ReadFrom.EditDFOW)+ReadFrom.Excel(j, 1, ReadFrom.EditDFOW);

					if(ToEdit.equalsIgnoreCase(EditIt)) {

						WebElement EditSpecSec =	FindElement(SpecSec1 , i , SpecSec2);
						EditSpecSec.clear();
						EditSpecSec.sendKeys(ReadFrom.Excel(j, 2, ReadFrom.EditDFOW)); 
						Print("Spec is edited as : " + ReadFrom.Excel(j, 2, ReadFrom.EditDFOW));

						WebElement EditDfow =	FindElement(Dfow1 , i , Dfow2);
						EditDfow.clear();
						EditDfow.sendKeys(ReadFrom.Excel(j, 3, ReadFrom.EditDFOW)); 

						Print("Dfow is edited as : " + ReadFrom.Excel(j, 3, ReadFrom.EditDFOW));


						Wait(5000);
						break;

					}

				}
			}
		}
		catch (Exception e) {
			Print(e.getMessage());
		}

	}


	public static void DeleteDFOW() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.DeleteDFOW);


		Print("eXCEL : " + ReadFrom.rowcount);

		try {

			for(int j =1; j<=ReadFrom.rowcount; j++)	{

				ElementNames = 	getElements("DFOWlist", DFOWLocators);
				int rowcount = 	ElementNames.size();
				Print("No of elements : " + rowcount);

				for(int i =1; i<=rowcount; i++)	{

					WebElement SpecSec =	FindElement(SpecSec1 , i , SpecSec2);

					String Specificaiton = 	SpecSec.getAttribute("value");


					WebElement Dfow =	FindElement(Dfow1 , i , Dfow2);
					String DFOWname =	Dfow.getAttribute("value");

					Wait(2000);

					String ToDelete = Specificaiton + DFOWname;


					String DeleteIt =	ReadFrom.Excel(j, 0, ReadFrom.DeleteDFOW)+ReadFrom.Excel(j, 1, ReadFrom.DeleteDFOW);

					if(ToDelete.equalsIgnoreCase(DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement(delete , i , delete1);
						Delete.click();

						Wait(2000);

						Click("YesDelete", DFOWLocators);

						Wait(5000);
						break;



					}
				}
			}
		}
		catch (Exception e) {
			Print(e.getMessage());
		}
	}




	public static void DfowBulkUpload() throws Throwable {
		Wait(2000);
		Robot robot = new Robot();
		StringSelection up = new StringSelection(ReadFrom.UploadDfowFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(up, null);


		Wait(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Wait(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Wait(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}



	public static void AddSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement fluentwaits = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Updated Successfully.']"));
			}
		});
	}
	
	public static void DeleteSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement fluentwaits = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Listed Successfully.']"));
			}
		});
	}
	
	public static void BulkSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement fluentwaits = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Created Successfully.']"));
			}
		});
	}

	public static void BrowseFiles() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement fluentwaits = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
			}
		});
	}
}
