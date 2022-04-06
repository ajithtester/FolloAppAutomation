package com.follo.module.method;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



public class F_03_DFOW extends Baseclass {


	public static void AddDFOW() throws Throwable {

		Wait(3000);

		ReadFrom.DynamicExcel(ReadFrom.AddDFOW);

		try {
			for(int Rows =1; Rows<=ReadFrom.rowcount; Rows++)		{	

				WebElement SpecSec = 	FindElement("SpecificationSectionRow", DFOWLocators, Rows);

				Clear(SpecSec);
				EnterValueInTheElement(SpecSec, ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));

				Print("Specification is entered as : " + ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));
				ExtentCucumberAdapter.addTestStepLog("Specification is entered as : " + ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));

				Wait(3000);

				WebElement dfow =	FindElement("DfowRow", DFOWLocators, Rows);

				Clear(dfow);
				EnterValueInTheElement(dfow, ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));

				Print("Dfow is entered as : " + ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));
				ExtentCucumberAdapter.addTestStepLog("Dfow is entered as : " + ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));

				Click("AddRow", DFOWLocators);
				Print("Add row is clicked");
				ExtentCucumberAdapter.addTestStepLog("Add row is clicked");

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}

	public static void SearchDFOW() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchDFOW);
		try {

			for(int SearchDfow =1; SearchDfow<=ReadFrom.rowcount; SearchDfow++)	{

				TypeDataInTheField("SearchDfow", DFOWLocators, ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW) + " is entered in the search bar");
				ClickEnter();
				Wait(6000);


				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);
				Print("No of dfow displayed : " + rowcount);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, i);

					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW);

					if(IsEqual(DFOWname, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + DFOWname);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DFOWname);
						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + DFOWname);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DFOWname);
					}


				}
				Clear("SearchDfow", DFOWLocators);
				Wait(3000);
				Click("ClearSearch", DFOWLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	public static void EditDFOW() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditDFOW);
		try {

			for(int EditDfow =1; EditDfow<=ReadFrom.rowcount; EditDfow++)	{


				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);
				Print("No of elements : " + rowcount);

				for(int DfowList =1; DfowList<=rowcount; DfowList++)		{

					WebElement SpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, DfowList);

					String Specificaiton = 	GetAttributeFromTheElement(SpecSec);


					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, DfowList);
					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String ToEdit = Specificaiton + DFOWname;


					String EditIt =	ReadFrom.Excel(EditDfow, 0, ReadFrom.EditDFOW)+ReadFrom.Excel(EditDfow, 1, ReadFrom.EditDFOW);


					if(IsEqual(ToEdit, EditIt)) {

						WebElement EditSpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, DfowList);
						Clear(EditSpecSec);
						EnterValueInTheElement(EditSpecSec, ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));

						Print("Spec is edited as : " + ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));
						ExtentCucumberAdapter.addTestStepLog("Specification is edited as : " + ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));

						WebElement EditDfowlist =	FindElement("DfowRow", DFOWLocators, DfowList);
						Clear(EditDfowlist);
						EnterValueInTheElement(EditDfowlist, ReadFrom.Excel(EditDfow,3, ReadFrom.EditDFOW));


						Print("Dfow is edited as : " + ReadFrom.Excel(EditDfow, 3, ReadFrom.EditDFOW));
						ExtentCucumberAdapter.addTestStepLog("Dfow is edited as : " + ReadFrom.Excel(EditDfow, 3, ReadFrom.EditDFOW));

						Wait(5000);
						break;

					}

				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}


	public static void DeleteDFOW() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.DeleteDFOW);
		try {

			for(int DeleteDfow =1; DeleteDfow<=ReadFrom.rowcount; DeleteDfow++)	{

				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);
				Print("No of elements : " + rowcount);

				for(int List =1; List<=rowcount; List++)	{

					WebElement SpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, List);

					String Specificaiton = 	GetAttributeFromTheElement(SpecSec);

					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, List);
					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String ToDelete = Specificaiton + DFOWname;


					String DeleteIt =	ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW)+ReadFrom.Excel(DeleteDfow, 1, ReadFrom.DeleteDFOW);



					if(IsEqual(ToDelete, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteDfow" ,DFOWLocators, List);
						Click(Delete);
						
						ExtentCucumberAdapter.addTestStepLog("Delete button is clicked");
						Print("Delete button is clicked");

						Wait(2000);

						Click("YesDelete", DFOWLocators);
						ExtentCucumberAdapter.addTestStepLog("Yes delete button is clicked");
						Print("Yes delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Listed Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeleteDfowMessage", DFOWLocators)){
							Print("DFOW deleted is : " + ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW));
							ExtentCucumberAdapter.addTestStepLog("DFOW deleted is : " + ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW));
							break;
						}
						else {
							PrintError("DFOW not deleted");
							ExtentCucumberAdapter.addTestStepLog("DFOW not deleted");
							Wait(5000);
							break;
						}
					}
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}




	public static void DfowBulkUpload() throws Throwable {
		Wait(2000);
		Robot FileUpload = new Robot();

		StringSelection str = new StringSelection(ReadFrom.UploadDfowFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		System.out.println(ReadFrom.UploadDfowFile);

		Wait(2000);
//		FileUpload.keyPress(KeyEvent.VK_ENTER);
//		FileUpload.keyRelease(KeyEvent.VK_ENTER);

		FileUpload.keyPress(KeyEvent.VK_CONTROL);
		FileUpload.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		FileUpload.keyRelease(KeyEvent.VK_CONTROL);
		FileUpload.keyRelease(KeyEvent.VK_V);
		//Wait(2000);
		FileUpload.keyPress(KeyEvent.VK_ENTER);
		FileUpload.keyRelease(KeyEvent.VK_ENTER);


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
