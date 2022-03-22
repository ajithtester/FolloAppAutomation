package com.follo.module.method;

import org.openqa.selenium.WebElement;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

public class Companies extends Baseclass {

	public static String Dfow1 = "//div/div[2]/ul[2]/li[";
	public static String Dfow2 ="]/div";

	public static void AddDCompany() throws Throwable {



		ReadFrom.DynamicExcel(ReadFrom.AddCompany);
		try {
			for(int i =1; i<=ReadFrom.rowcount; i++)		{	
				Click("NewCompany", CompaniesLocators);

				Wait(3000);
				try {
					if(getElement("Dfow", CompaniesLocators).isDisplayed()) {
						Click("Dfow", CompaniesLocators);

						ReadFrom.DynamicExcel(ReadFrom.Dfow);

						for(int k =1; k<=ReadFrom.rowcount; k++)		{	
							String DfowInExcel = ReadFrom.Excel(k, 0,ReadFrom.Dfow);
							System.out.println(DfowInExcel);
							ElementNames = 	getElements("DfowList", CompaniesLocators);
							int rowcountofthelist = 	ElementNames.size();
							Print("No of elements : " + rowcountofthelist);

							for(int j =1; j<=rowcountofthelist; j++)		{	

								WebElement Dfow = 	FindElement(Dfow1, j, Dfow2);
								String DfowInDropdown = 	Dfow.getText();
								System.out.println(DfowInDropdown);

								if(DfowInDropdown.equalsIgnoreCase(DfowInExcel)){
									Dfow.click();
									break;
								}
								else {
									System.out.println("Not matched");
								}


							}
						} }
				}
				catch (Exception e) {
					System.err.println(e.getMessage());
				}


				Wait(2000);
				TypeDataInTheField("CompanyName", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 0, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("AddressLine1", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 2, ReadFrom.AddCompany));

				Wait(2000);
				ClickEnter();

				Wait(2000);
				TypeDataInTheField("AddressLine2", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 3, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("City", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 4, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("State", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 5, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("Zipcode", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 6, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("Country", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 7, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("Website", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 8, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("AdditionalNotes", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, 9, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("SubmitButton", ReadFrom.CompaniesLocators, ReadFrom.Excel(i, i, ReadFrom.AddCompany));

				Wait(2000);
				Click("SubmitButton", ReadFrom.CompaniesLocators);

			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
