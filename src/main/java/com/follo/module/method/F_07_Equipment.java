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

public class F_07_Equipment extends Baseclass {

	public static void AddEquipment() throws Throwable {

		Wait(3000);

		ReadFrom.DynamicExcel(ReadFrom.AddEquipment);

		try {
			for(int AddEquipment =1; AddEquipment<=ReadFrom.rowcount; AddEquipment++)		{	

				Click("AddNewEquipment", EquipmentLocators);
				ExtentCucumberAdapter.addTestStepLog("Add new equipment button is clicked");
				Print("Add new equipment button is clicked");
				Wait(4000);
				WaitForTheElement("EquipmentName", EquipmentLocators);
				if(IsElementDisplayed("EquipmentName", EquipmentLocators)) {

					TypeDataInTheField("EquipmentName", EquipmentLocators, ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
					ExtentCucumberAdapter.addTestStepLog("Equipment name is entered as : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
					Print("Equipment name is entered as : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));

					Wait(2000);

					SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
					ExtentCucumberAdapter.addTestStepLog("Equipment type is entered as : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
					Print("Equipment type is entered as : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));

					Wait(2000);

					SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
					ExtentCucumberAdapter.addTestStepLog("Contact person is entered as : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
					Print("Contact person is entered as : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));

					Click("SubmitButton", EquipmentLocators);
					ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
					Print("Submit button is clicked");
				}
				else {
					ExtentCucumberAdapter.addTestStepLog("Equipment popup is not opened button is clicked");
					Print("Equipment popup is not opened button is clicked");

				}
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Equipment added successfully.']"));
					}
				});

				if(IsElementDisplayed("EquipmentAdded", EquipmentLocators)) {
					Click("EquipmentAdded", EquipmentLocators);
					Print("Equipment added is : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
					ExtentCucumberAdapter.addTestStepLog("Equipment added is : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				}
				else {

					PrintError("Equipment is not added");
					ExtentCucumberAdapter.addTestStepLog("Equipment is not added");
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	public static void EditEquipment() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditEquipment);

		try {

			for(int EditEquipmentDetails =1; EditEquipmentDetails<=ReadFrom.rowcount; EditEquipmentDetails++)	{


				int rowcount = SizeOfTheList("EditButtonLocator", EquipmentLocators);


				for(int EditButton =1; EditButton<=rowcount; EditButton++)	{

					WebElement EquipmentList =	FindElement("EquipmentList" , EquipmentLocators , EditButton);

					String EquipmentListList = 	GetTextFromTheElement(EquipmentList);


					String EditIt =	ReadFrom.Excel(EditEquipmentDetails, 0, ReadFrom.EditEquipment);


					if(IsEqual(EquipmentListList, EditIt)) {

						Wait(2000);

						WebElement Edit =	FindElement("EditButton" ,EquipmentLocators, EditButton);
						Click(Edit);
						Wait(2000);

						Clear("EquipmentName", EquipmentLocators);

						TypeDataInTheField("EquipmentName", EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));
						ExtentCucumberAdapter.addTestStepLog("Equipment name is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));
						Print("Equipment name is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));

						Wait(2000);

						SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));
						ExtentCucumberAdapter.addTestStepLog("Equipment type name is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));
						Print("Equipment type  is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));


						Wait(2000);

						SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));
						ExtentCucumberAdapter.addTestStepLog("Contact person is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));
						Print("Contact person is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));

						Wait(2000);
						Click("SubmitButton", EquipmentLocators);

						Wait<WebDriver> MemberUpdated = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						WebElement MemberUpdate = MemberUpdated.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Equipment updated successfully.']"));
							}
						});

						if(IsElementDisplayed("EquipmentEdit", EquipmentLocators)) {

							Print("Updated equipment is : " + EquipmentListList );
							ExtentCucumberAdapter.addTestStepLog("Updated equipment is : " + EquipmentListList );
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

	public static void SearchEquipment() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchEquipment);

		try {

			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{
				Click("SearchButton", EquipmentLocators);
				Wait(2000);

				TypeDataInTheField("Search", EquipmentLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment) + " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment) + " is entered in the search bar");

				Wait(5000);


				int rowcount = 	SizeOfTheList("EquipmentLists", EquipmentLocators);
				Print("No of equipment displayed : " + rowcount);

				for(int SearchedEquipment =1; SearchedEquipment<=rowcount; SearchedEquipment++)	{

					WebElement Equipment =	FindElement("EquipmentList", EquipmentLocators, SearchedEquipment);
					String EquipmentName =	GetTextFromTheElement(Equipment);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment);

					if(IsEqual(EquipmentName, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + EquipmentName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + EquipmentName);

						Wait(3000);
						break;

					}
					else {
						PrintError("Displayed value is : " + EquipmentName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + EquipmentName);
					}
				}
				
				Wait(5000);
				Clear("Search", EquipmentLocators);
				Wait(3000);
				Click("ClearSearch", EquipmentLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	public static void DeleteEquipment() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.DeleteEquipment);
		try {

			for(int DeleteEquipment =1; DeleteEquipment<=ReadFrom.rowcount; DeleteEquipment++)	{


				int rowcount = 	SizeOfTheList("DeleteButtonLocator", EquipmentLocators);
				Print("No of elements : " + rowcount);

				for(int DeleteButton =1; DeleteButton<=rowcount; DeleteButton++)	{

					WebElement Equipment =	FindElement("EquipmentList", EquipmentLocators, DeleteButton);

					String EquipmentName = 	GetTextFromTheElement(Equipment);

					String DeleteIt =	ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment);


					if(IsEqual(EquipmentName, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteButton" ,EquipmentLocators, DeleteButton);
						Click(Delete);
						Wait(2000);

						Click("YesDelete", EquipmentLocators);
						ExtentCucumberAdapter.addTestStepLog("Equipment is selected and delete button is clicked");
						Print("Equipment is selected and delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Equipment deleted successfully.']"));
							}
						});

						if(IsElementDisplayed("EquipmentDeleted", EquipmentLocators)){
							Click("EquipmentDeleted", EquipmentLocators);
							Print("Equipment deleted is : " + ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment));
							ExtentCucumberAdapter.addTestStepLog("Equipment deleted is : " + ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment));
							break;
						}else {
							PrintError("Equipment not deleted");
							ExtentCucumberAdapter.addTestStepLog("Equipment not deleted");

							Wait(3000);

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
	
	public static void FilterEquipment() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.FilterEquipment);



		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{



				Click("FilterIcon", EquipmentLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
				Print("Filter icon is clicked");
				Wait(6000);
			
				
				
				TypeDataInTheField("EquipmentNameInFilter", EquipmentLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));
				ExtentCucumberAdapter.addTestStepLog("Equipment name is entered as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));
				Print("Equipment name is entered as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));

				Click("FilterApply", EquipmentLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(3000);

				
				
				int rowcount = 	SizeOfTheList("EquipmentLists", EquipmentLocators);
				Print("No of Equipmentsedisplayed : " + rowcount);


				for(int EquipmentLists =1; EquipmentLists<=rowcount; EquipmentLists++)	{

					WebElement Equipment =	FindElement("EquipmentList" , EquipmentLocators, EquipmentLists );
					String EquipmentName =	GetTextFromTheElement(Equipment);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment);


					if(	IsEqual(EquipmentName, FilteredValue)) {

						Wait(2000);
						Print("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
						Wait(3000);

					}
					else {
						PrintError("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
					}


				}
				Click("FilterIcon", EquipmentLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Wait(3000);
				Click("FilterReset", EquipmentLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter reset button is clicked");
				Print("Filter reset button is clicked");

				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


}
