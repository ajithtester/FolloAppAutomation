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

public class F_04_Companies extends Baseclass {




	public static void AddDCompany() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.AddCompany);

		try {

			for(int AddCompany =1; AddCompany<=ReadFrom.rowcount; AddCompany++)		{	
				Wait(2000);
				Click("NewCompany", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("New company button is clicked");
				Print("New company button is clicked");

				Wait(5000);
				if(IsElementDisplayed("Dfow", CompaniesLocators)) {

					Wait(2000);
					TypeDataInTheField("CompanyName", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Company name is entered as : " +ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
					Print("Company name is entered as : " +ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));


					Wait(2000);
					TypeDataInTheField("AddressLine1", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Address line1 is entered as : " +ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
					Print("Address line1 is entered as : " +ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));

					Wait(2000);
					ClickEnter();

					Wait(2000);
					TypeDataInTheField("AddressLine2", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Address line2 is entered as : " +ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));
					Print("Address line2 is entered as : " +ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("City", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("City is entered as : " +ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
					Print("City is entered as : " +ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("State", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("State is entered as : " +ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
					Print("State is entered as : " +ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("Zipcode", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 6, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Zipcode is entered as : " +ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));
					Print("Zipcode is entered as : " +ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("Country", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Country is entered as : " +ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
					Print("Country is entered as : " +ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("Website", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Website is entered as : " +ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));
					Print("Website is entered as : " +ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("AdditionalNotes", ReadFrom.CompaniesLocators, ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));
					ExtentCucumberAdapter.addTestStepLog("Additional notes is entered as : " +ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));
					Print("Additional notes is entered as : " +ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));

					Wait(2000);
					try {
						Click("Dfow", CompaniesLocators);
						ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

						//	ReadFrom.DynamicExcel(ReadFrom.AddCompanyDfow);

						//	for(int AddCompanyDfow =1; AddCompanyDfow<=ReadFrom.rowcount; AddCompanyDfow++)		{	
						String DfowInExcel = ReadFrom.Excel(AddCompany, 1,ReadFrom.AddCompany);
						Print(DfowInExcel);

						int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);
							Print(DfowInDropdown);


							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + DfowInDropdown );
								Print("Dfow is selected as : " + DfowInDropdown );
								break;
							}
							else {
								PrintError("Not matched");
								ExtentCucumberAdapter.addTestStepLog("Not matched");
							}
							//}
							//} 
						}
					}
					catch (Exception e) {
						PrintError(e.getMessage());
						ExtentCucumberAdapter.addTestStepLog(e.getMessage());
					}

					Wait(2000);

					Click("SubmitButton", ReadFrom.CompaniesLocators);
					ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
					Wait(5000);

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Company Created Successfully.']"));
						}
					});

					if(IsElementDisplayed("CompanyAdded", CompaniesLocators)){
						Print("Company added is : " + ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
						ExtentCucumberAdapter.addTestStepLog("Company added is : " + ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));

					}else {
						PrintError("Company not added");
						ExtentCucumberAdapter.addTestStepLog("Company not added");

					}

				}

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}


	public static void SearchCompany() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchCompany);
		try {
			Click("Search", CompaniesLocators);
			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				ExtentCucumberAdapter.addTestStepLog("Search button is clicked");

				TypeDataInTheField("SearchCompany", CompaniesLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany) + " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany) + " is entered in the search bar");

				ClickEnter();
				Wait(6000);

				int rowcount = 	SizeOfTheList("CompanyList", CompaniesLocators);
				Print("No of Companies displayed : " + rowcount);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Company =	FindElement("CompanyListed" ,CompaniesLocators, i);
					String CompanyName =	GetTextFromTheElement(Company);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany);


					if(IsEqual(CompanyName, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + CompanyName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + CompanyName);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + CompanyName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + CompanyName);
					}


				}
				Wait(3000);
				Clear("SearchDfow", DFOWLocators);
				Wait(3000);
				Click("ClearSearch", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");
				Wait(3000);
				

			}
			Clear("SearchDfow", DFOWLocators);
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	public static void FilterCompany() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.FilterCompany);
		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{
				Click("FilterIcon", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				TypeDataInTheField("FilterCompanyName", CompaniesLocators, ReadFrom.Excel(Filter, 0, ReadFrom.SearchCompany));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(Filter, 0, ReadFrom.SearchGates) + " is entered in the search bar");
				Print(ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany) + " is entered in the search bar");


				Wait(2000);
				Click("FilterApply", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(6000);

				int rowcount = 	SizeOfTheList("CompanyList", CompaniesLocators);
				Print("No of companies displayed : " + rowcount);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Company =	FindElement("CompanyListed" ,CompaniesLocators, i);
					String CompanyName =	GetTextFromTheElement(Company);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany);


					if(	IsEqual(CompanyName, FilteredValue)) {

						Wait(2000);
						Print("Displayed value is : " + CompanyName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + CompanyName);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + CompanyName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + CompanyName);
					}


				}
				Click("FilterIcon", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Click("FilterReset", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter Reset button is clicked");
				Print("Filter Reset button is clicked");
				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void DeleteCompany() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.DeleteCompany);
		try {

			for(int DeleteCompany =1; DeleteCompany<=ReadFrom.rowcount; DeleteCompany++)	{


				int rowcount = SizeOfTheList("CompanyList", CompaniesLocators);
				Print("No of elements : " + rowcount);

				for(int DeleteButton =2; DeleteButton<=rowcount; DeleteButton++)	{

					WebElement CompanyNames =	FindElement("CompanyListed" ,CompaniesLocators, DeleteButton);

					String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);
					Print(CompanyNamesList);

					String DeleteIt =	ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany);



					if(IsEqual(CompanyNamesList, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteCompany" , CompaniesLocators, DeleteButton-1);
						Click(Delete);


						Wait(2000);

						Click("YesDelete", CompaniesLocators);
						ExtentCucumberAdapter.addTestStepLog("Company is selected and delete button is clicked");
						Print("Company is selected and delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Company Deleted Successfully.']"));
							}
						});

						if(IsElementDisplayed("CompanyDeleted", CompaniesLocators)){
							Print("Company deleted is : " + ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany));
							ExtentCucumberAdapter.addTestStepLog("Company deleted is : " + ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany));
							break;
						}else {
							PrintError("Company not deleted");
							ExtentCucumberAdapter.addTestStepLog("Company not deleted");

							Wait(3000);
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

	public static void EditCompany() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);
		try {

			for(int EditCompanyDetails =1; EditCompanyDetails<=ReadFrom.rowcount; EditCompanyDetails++)	{


				int rowcount = SizeOfTheList("CompanyList", CompaniesLocators);
				Print("No of elements : " + rowcount);

				for(int CompanyList =1; CompanyList<=rowcount; CompanyList++)	{

					WebElement CompanyNames =	FindElement("CompanyListed" ,CompaniesLocators, CompanyList);

					String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);


					String EditIt =	ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails);


					if(IsEqual(CompanyNamesList, EditIt)) {

						Wait(2000);

						WebElement EditButton =	FindElement("EditCompany" ,CompaniesLocators,  CompanyList);
						Click(EditButton);
						ExtentCucumberAdapter.addTestStepLog("Edit button is clicked");
						Print("Edit button is clicked");
						/////////////////////////////////////////////////////////////////////////////////

						//						ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);
						//						Print("eXCEL EditCompanyDetails : " + ReadFrom.rowcount);
						//for(int EditCompanyDetails =1; EditCompanyDetails<=ReadFrom.rowcount; EditCompanyDetails++)		{	


						Wait(3000);
						if(IsElementDisplayed("DropdownList", CompaniesLocators)) {

							Wait(2000);
							Clear("CompanyName", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("Company name is cleared");
							Print("Company name is cleared");

							TypeDataInTheField("CompanyName", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("Company name is edited as : " + ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));
							Print("Company name is edited as : " + ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));


							Wait(2000);
							Clear("AddressLine1", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("AddressLine1 is cleared");
							Print("AddressLine1 is cleared");

							TypeDataInTheField("AddressLine1", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("AddressLine1 is edited as : " + ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));
							Print("AddressLine1 is edited as : " + ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));

							Wait(2000);
							ClickEnter();

							Wait(2000);
							Clear("AddressLine2", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("AddressLine2 is cleared");
							Print("AddressLine2 is cleared");

							TypeDataInTheField("AddressLine2", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("AddressLine2 is edited as : " + ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));
							Print("AddressLine2 is edited as : " + ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("City", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("City is cleared");
							Print("City is cleared");

							TypeDataInTheField("City", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("City is edited as : " + ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));
							Print("City is edited as : " + ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("State", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("State is cleared");
							Print("State is cleared");

							TypeDataInTheField("State", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("State is edited as : " + ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));
							Print("State is edited as : " + ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("Zipcode", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("Zipcode is cleared");
							Print("Zipcode is cleared");

							TypeDataInTheField("Zipcode", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("Zipcode is edited as : " + ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));
							Print("Zipcode is edited as : " + ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("Country", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("Country is cleared");
							Print("Country is cleared");

							TypeDataInTheField("Country", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("Country is edited as : " + ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));
							Print("Country is edited as : " + ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("Website", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("Website is cleared");
							Print("Website is cleared");

							TypeDataInTheField("Website", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("Website is edited as : " + ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));
							Print("Website is edited as : " + ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("AdditionalNotes", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("AdditionalNotes is cleared");
							Print("AdditionalNotes is cleared");

							TypeDataInTheField("AdditionalNotes", ReadFrom.CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));
							ExtentCucumberAdapter.addTestStepLog("AdditionalNotes is edited as : " + ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));
							Print("AdditionalNotes is edited as : " + ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));


							Wait(2000);
							try {
								Click("DropdownList", CompaniesLocators);
								ExtentCucumberAdapter.addTestStepLog("Dropdown is clicked");
								Print("Dropdown is clicked");

								Click("SelectAllInDropdown", CompaniesLocators);

								Click("UnSelectAllInDropdown", CompaniesLocators);
								//ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);

								//	for(int AddCompanyDfow =1; AddCompanyDfow<=ReadFrom.rowcount; AddCompanyDfow++)		{	
								String DfowInExcel = ReadFrom.Excel(EditCompanyDetails, 2,ReadFrom.EditCompanyDetails);
								Print(DfowInExcel);
								
			
								int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);
								Print("No of elements : " + rowcountofthelist);

								for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	

									WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
									String DfowInDropdown = 	GetTextFromTheElement(Dfow);
									Print(DfowInDropdown);

									if(DfowInDropdown.equalsIgnoreCase(DfowInExcel)){
										Click(Dfow);
										ExtentCucumberAdapter.addTestStepLog(DfowInDropdown + " is selected from the dropdown");
										Print(DfowInDropdown + " is selected from the dropdown");
										break;
									}
									else {
										PrintError("Not matched");
										ExtentCucumberAdapter.addTestStepLog("Not matched");
									}
									//}
									//} 
								}
							}
							catch (Exception e) {
								PrintError(e.getMessage());
								ExtentCucumberAdapter.addTestStepLog(e.getMessage());
							}
							Wait(2000);
							Click("SubmitButton", ReadFrom.CompaniesLocators);
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
							Print("Submit button is clicked");
							
							Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//div[@aria-label='Company Updated Successfully.']"));
								}
							});

							if(IsElementDisplayed("CompanyEdited", CompaniesLocators)){
								Print("Company edited is : " + ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails));
								ExtentCucumberAdapter.addTestStepLog("Company edited is : " + ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails));
								break;
							}else {
								PrintError("Company not edited");
								ExtentCucumberAdapter.addTestStepLog("Company not edited");

							}

						}

						//	}
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

}
