package com.follo.module.method;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class F_05_Members extends Baseclass {
	
	@FindBy(xpath ="//button[@type='submit']")
	private static WebElement FilterApply;

public F_05_Members (WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
	public static void InviteMembers() throws Throwable {

		Wait(3000);

		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);

		try {
			for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
				TypeDataInTheField("EnterMailId", MembersLocators, ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers));


				Wait(2000);
				ClickEnter();


				Wait(2000);
				WebElement Email =	FindElement("EnteredMailList" , MembersLocators, invite) ;

				String EnteredEmail = Email.getText();


				if(IsEqual(EnteredEmail, ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers))) {
					Print("Entered mail id is : " + ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers) );
					ExtentCucumberAdapter.addTestStepLog("Entered mail id is : " + ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers));
				}
				else {

					PrintError("Email id not entered");
					ExtentCucumberAdapter.addTestStepLog("Email id not entered");
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	public static void SelectCompany() throws Throwable {

		Wait(3000);

		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);
		try {
			for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
				String CompanyInExcel = ReadFrom.Excel(invite, 1,ReadFrom.InviteMembers);
				Print(CompanyInExcel);

				WebElement Email =	FindElement("EnteredMailList" , MembersLocators, invite) ;

				String EnteredEmail = GetTextFromTheElement(Email);

				WebElement	SelectCompany =	FindElement("SelectComanyDropdown" , MembersLocators, invite);
				Click(SelectCompany);
				ExtentCucumberAdapter.addTestStepLog("Select company dropdown is clicked");
				Print("Select company dropdown is clicked");
				Wait(3000);

				List<WebElement> CompanyList = getElements("CompanyListInDropdown", MembersLocators);
				for(WebElement Value:CompanyList) {
					String	CompanyName = GetTextFromTheElement(Value);
					Print(CompanyName);

					if(IsEqual(CompanyName, CompanyInExcel)){
						Wait(2000);
						Click(Value);

						Print("Company selected for the member : " + EnteredEmail + " : " + CompanyInExcel);
						ExtentCucumberAdapter.addTestStepLog("Company selected for the member : " + EnteredEmail + " is : " + CompanyInExcel);
						Wait(3000);
						break;
					}
				}


				String RoleInExcel = ReadFrom.Excel(invite, 2,ReadFrom.InviteMembers);
				Print(RoleInExcel);

				WebElement	SelectRole =	FindElement("SelectRoleDropdown" , MembersLocators, invite);
				Click(SelectRole);
				ExtentCucumberAdapter.addTestStepLog("Select role dropdown is clicked");
				Print("Select role dropdown is clicked");
				Wait(3000);

				List<WebElement> RoleList = getElements("RoleListInDropdown", MembersLocators);
				for(WebElement Value :RoleList) {
					String	RoleName = GetTextFromTheElement(Value);
					Print(RoleName);

					if(IsEqual(RoleName, RoleInExcel)){
						Wait(2000);
						Click(Value);

						Print("Role selected for the member : " + EnteredEmail + " : " + RoleInExcel);
						ExtentCucumberAdapter.addTestStepLog("Role selected for the member : " + EnteredEmail + " : " + RoleInExcel);
						Wait(3000);
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



	public static void SelectRole() throws Throwable {

		Wait(3000);

		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);
		try {
			for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
				String RoleInExcel = ReadFrom.Excel(invite, 2,ReadFrom.InviteMembers);
				Print(RoleInExcel);

				WebElement	SelectRole =	FindElement("SelectRoleDropdown" , MembersLocators, invite);
				Click(SelectRole);
				ExtentCucumberAdapter.addTestStepLog("Select role dropdown is clicked");
				Print("Select role dropdown is clicked");
				Wait(3000);

				List<WebElement> RoleList = getElements("RoleListInDropdown", MembersLocators);
				for(WebElement Value :RoleList) {
					String	RoleName = GetTextFromTheElement(Value);
					Print(RoleName);

					if(IsEqual(RoleName, RoleInExcel)){
						Wait(2000);
						Click(Value);

						Print("Role selected is : " + RoleInExcel);
						ExtentCucumberAdapter.addTestStepLog("Role selected is : " + RoleInExcel);
						Wait(3000);
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

	public static void InviteSentPopup() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Invites sent Successfully.']"));
			}
		});

	}


	public static void ReInviteMembers() throws Throwable {

		Wait(3000);


		try {


			int rowcountofthelist = SizeOfTheList("StatusList", MembersLocators);
			Print("Status count : " + rowcountofthelist);

			for(int reinvite =1; reinvite<=rowcountofthelist; reinvite++)		{	
				WebElement Status =	FindElement("StatusOfMember",MembersLocators,  reinvite);

				String StatusText = GetTextFromTheElement(Status);


				if(IsEqual(StatusText, "Pending")) {

					WebElement Resend =	FindElement("ResendInvite", MembersLocators, reinvite);
					Click(Resend);
					ExtentCucumberAdapter.addTestStepLog("Resend invite button is clcked");
					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Resend Invite Link sent Successfully.']"));
						}
					});

					if(IsElementDisplayed("ResendMessagePopup", MembersLocators)) {
						Click("ResendMessagePopup", MembersLocators);
						WebElement EmailId =	FindElement("EmailIdList", MembersLocators, reinvite);

						String Member =	GetTextFromTheElement(EmailId);

						Print("Resent invite sent to the account : " + Member );
						ExtentCucumberAdapter.addTestStepLog("Resent invite sent to the account : " + Member );
						Wait(3000);

					}
					else {
						PrintError("Resent invite failed");
						ExtentCucumberAdapter.addTestStepLog("Resent invite failed");
					}
				}

				else {
					PrintError("Status of the account is : " + StatusText);
					ExtentCucumberAdapter.addTestStepLog("Status of the account is : " + StatusText);

				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void SearchMember() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchMembers);



		try {
			Click("Search", MembersLocators);
			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				TypeDataInTheField("SearchMember", MembersLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers));
				ExtentCucumberAdapter.addTestStepLog("Value entered in search bar is : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers));
				Print("Value entered in search bar is : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers));

				Wait(5000);


				int rowcount = 	SizeOfTheList("EmailList", MembersLocators);
				Print("No of Members displayed : " + rowcount);

				for(int MembersCount =1; MembersCount<=rowcount; MembersCount++)	{

					WebElement Members =	FindElement("EmailIdList", MembersLocators, MembersCount);
					String MembersEmailId =	GetTextFromTheElement(Members);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers);



					if(IsEqual(MembersEmailId, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + MembersEmailId);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + MembersEmailId);
						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + MembersEmailId);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + MembersEmailId);
					}


				}
				//Wait(2000);
				//Click("ClearSearch", MembersLocators);
				//ExtentCucumberAdapter.addTestStepLog("Clear button is clicked insearch bar");
				Wait(3000);
				Clear("SearchDfow", DFOWLocators);
				ExtentCucumberAdapter.addTestStepLog("Search bar is cleared");
				PrintError("Search bar is cleared");
				Wait(3000);
				Click("ClearSearch", MembersLocators);
				Wait(2000);
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	public static void FilterMemberOnRole() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.FilterMembers);



		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{



				Click("FilterIcon", MembersLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
				Print("Filter icon is clicked");
				Wait(3000);
				//Click("RoleDropdown", MembersLocators);


				SelectFromDropdown("RoleDropdown", MembersLocators, "3");
				ExtentCucumberAdapter.addTestStepLog("Value selected from the role dropdown is : " + "3");
				Print("Value selected from the role dropdown is : " + "3");

				Click("FilterApply", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(3000);


				int rowcount = 	SizeOfTheList("RoleNameList", MembersLocators);
				Print("No of companies displayed : " + rowcount);


				for(int RoleList =1; RoleList<=rowcount; RoleList++)	{

					WebElement Role =	FindElement("RoleList" , MembersLocators, RoleList );
					String RoleName =	GetTextFromTheElement(Role);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterMembers);


					if(	IsEqual(RoleName, FilteredValue)) {

						Wait(2000);
						Print("Filtered value is : " + FilteredValue + " : Displayed value is : " + RoleName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " : Displayed value is : " + RoleName);
						Wait(3000);

					}
					else {
						PrintError("Filtered value is : " + FilteredValue + " : Displayed value is : " + RoleName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " : Displayed value is : " + RoleName);
					}


				}
				Click("FilterIcon", MembersLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Wait(3000);
				Click("FilterReset", MembersLocators);
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


	public static void FilterMemberOnCompany() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.FilterMembers);
		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{



				Click("FilterIcon", MembersLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");
				
				Wait(2000);
				
				Click("CompanyInFilter", MembersLocators);
				
				ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");
				Print("Company dropdown is clicked");

				Wait(3000);

				String CompanyInExcel = ReadFrom.Excel(Filter, 1, ReadFrom.FilterMembers);
				List<WebElement> CompanyList = getElements("FilterCompany", MembersLocators);
				int count =	CompanyList.size();
				for(int list = 1 ; list<=count ; list++) {
					for(WebElement Value :CompanyList) {
						String	RoleName = GetTextFromTheElement(Value);
						Print(RoleName);

						if(IsEqual(RoleName, CompanyInExcel)){
							Wait(2000);
							Click(Value);

							Print("Company selected is : " + CompanyInExcel);
							ExtentCucumberAdapter.addTestStepLog("Company selected is : " + CompanyInExcel);
							Wait(3000);
							break;
						}

					}
				}
				//Click("Name", MembersLocators);
				//Wait(2000);
				//SelectFromDropdown("RoleDropdown", MembersLocators, "3");
				//ClickTab();
				
			//	ClickTab();
				//Wait(3000);
			//	ClickEnter();
//				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//						.withTimeout(Duration.ofSeconds(120))
//						.pollingEvery(Duration.ofSeconds(5))
//						.ignoring(NoSuchElementException.class);
//
//
//				WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
//					public WebElement apply(WebDriver driver) {
//						return driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
//					}
//				});
//				/WaitForTheElement("FilterApply2", CompaniesLocators);
				//WebElement apply =  getElement("FilterApply", MembersLocators);
//			/	explicitwaitclickable(apply);
				//Click(apply);
				
				//doubleClick(FilterApply);
				//FilterApply.click();
				//Click("FilterApply", CompaniesLocators);
				Click("FilterReset", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				//	Click("FilterApply", CompaniesLocators);
				Wait(3000);


				int rowcount = 	SizeOfTheList("CompanyNameList", MembersLocators);
				Print("No of companies displayed : " + rowcount);


				for(int CompanyListed =1; CompanyListed<=rowcount; CompanyListed++)	{

					WebElement Company =	FindElement("CompanyList" , MembersLocators, CompanyListed );
					String CompanyName =	GetTextFromTheElement(Company);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 1, ReadFrom.FilterMembers);


					if(IsEqual(CompanyName, FilteredValue)) {

						Wait(2000);
						Print("Filtered value is : " + FilteredValue + " Displayed value is : " + CompanyName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " Displayed value is : " + CompanyName);
						Wait(3000);

					}
					else {
						PrintError("Filtered value is : " + FilteredValue + " Displayed value is : " + CompanyName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " Displayed value is : " + CompanyName);
					}


				}
				
				
				Click("FilterIcon", MembersLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");
				Wait(3000);

				Click("FilterReset", MembersLocators);
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


	public static void DeleteMembers() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.DeleteMembers);


		try {

			for(int DeleteMembers =1; DeleteMembers<=ReadFrom.rowcount; DeleteMembers++)	{


				int rowcount = 	SizeOfTheList("CompanyNameList", MembersLocators);
				Print("No of elements : " + rowcount);

				for(int TotalMembers =1; TotalMembers<=rowcount; TotalMembers++)	{

					WebElement EmailIdList =	FindElement("EmailIdList" ,MembersLocators, TotalMembers);

					String EmailIds = 	GetTextFromTheElement(EmailIdList);

					String DeleteIt =	ReadFrom.Excel(DeleteMembers, 0, ReadFrom.DeleteMembers);

					if(IsEqual(EmailIds, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteButton" , MembersLocators ,TotalMembers);
						Click(Delete);

						ExtentCucumberAdapter.addTestStepLog("Delete button is clicked");
						Print("Delete button is clicked");
						Wait(2000);

						Click("YesDelete", MembersLocators);
						ExtentCucumberAdapter.addTestStepLog("Yes delete button is clicked");
						Print("Yes delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Member Deleted Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeleteMessageSuccessfully", MembersLocators)){

							Print("Member deleted is : " + ReadFrom.Excel(DeleteMembers, 0, ReadFrom.DeleteMembers));
							ExtentCucumberAdapter.addTestStepLog("Member deleted is : " + ReadFrom.Excel(DeleteMembers, 0, ReadFrom.DeleteMembers));
							break;
						}else {
							PrintError("Member not deleted");
							ExtentCucumberAdapter.addTestStepLog("Member not deleted");
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

	public static void EditMembers() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditMembers);

		try {

			for(int EditMemberDetails =1; EditMemberDetails<=ReadFrom.rowcount; EditMemberDetails++)	{


				int rowcount = SizeOfTheList("CompanyNameList", MembersLocators);
				Print("No of elements : " + rowcount);

				for(int MemberList =1; MemberList<=rowcount; MemberList++)	{

					WebElement MemberNames =	FindElement("EmailIdList" , MembersLocators , MemberList);

					String MemberNamesList = 	GetTextFromTheElement(MemberNames);


					String EditIt =	ReadFrom.Excel(EditMemberDetails, 0, ReadFrom.EditMembers);


					if(IsEqual(MemberNamesList, EditIt)) {

						WebElement Status =			FindElement("StatusOfMember" , MembersLocators , MemberList);
						String StatusOfMember = GetTextFromTheElement(Status);

						if(IsEqual(StatusOfMember, "Completed")) {

							Wait(2000);
							WebElement	EditMember = 		FindElement("EditMembers" , MembersLocators , 1);
							Click(EditMember);
							ExtentCucumberAdapter.addTestStepLog("Edit button  is clicked");
							Print("Edit button  is clicked");

							Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//input[@placeholder='First Name']"));
								}
							});

							Wait(2000);
							Clear("FirstName", MembersLocators);
							TypeDataInTheField("FirstName", MembersLocators, ReadFrom.Excel(EditMemberDetails, 1, ReadFrom.EditMembers));
							ExtentCucumberAdapter.addTestStepLog("Firstname is edited as : " + ReadFrom.Excel(EditMemberDetails, 1, ReadFrom.EditMembers));
							Print("Firstname is edited as : " + ReadFrom.Excel(EditMemberDetails, 1, ReadFrom.EditMembers));

							Wait(2000);
							Clear("LastName", MembersLocators);
							TypeDataInTheField("LastName", MembersLocators, ReadFrom.Excel(EditMemberDetails, 2, ReadFrom.EditMembers));
							ExtentCucumberAdapter.addTestStepLog("Lastname is edited as : " +ReadFrom.Excel(EditMemberDetails, 2, ReadFrom.EditMembers));
							Print("Lastname is edited as : " +ReadFrom.Excel(EditMemberDetails, 2, ReadFrom.EditMembers));

							Wait(2000);
							SelectFromDropdown("PhoneCode", MembersLocators, ReadFrom.Excel(EditMemberDetails, 3, ReadFrom.EditMembers));
							ExtentCucumberAdapter.addTestStepLog("Phonecode is edited as : " + ReadFrom.Excel(EditMemberDetails, 3, ReadFrom.EditMembers));
							Print("Phonecode is edited as : " + ReadFrom.Excel(EditMemberDetails, 3, ReadFrom.EditMembers));

							Wait(2000);
							Clear("MobileNumber", MembersLocators);
							TypeDataInTheField("MobileNumber", MembersLocators, ReadFrom.Excel(EditMemberDetails, 4, ReadFrom.EditMembers));
							ExtentCucumberAdapter.addTestStepLog("Mobile number is edited as : " + ReadFrom.Excel(EditMemberDetails, 4, ReadFrom.EditMembers));
							Print("Mobile number is edited as : " + ReadFrom.Excel(EditMemberDetails, 4, ReadFrom.EditMembers));

							Wait(2000);
							Click("SubmitButton", MembersLocators);
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
							Print("Submit button is clicked");

							Wait<WebDriver> MemberUpdated = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							WebElement MemberUpdate = MemberUpdated.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//div[@aria-label='Member Updated Successfully.']"));
								}
							});

							if(IsElementDisplayed("MemberUpdated", MembersLocators)) {

								Print("Updated memeber is : " + MemberNamesList );
								ExtentCucumberAdapter.addTestStepLog("Updated memeber is : " + MemberNamesList );
							}

						}

						else {
							PrintError("Status of the member is : " + StatusOfMember + " : Thus this member can't be edited");
							ExtentCucumberAdapter.addTestStepLog("Status of the member " + MemberNamesList +  " is : " + StatusOfMember + " : Thus this member can't be edited");
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

	public static void RemoveAll() throws Throwable {

		try {

			int size =	GetSize("CompanyList", CompaniesLocators);

			if(size<=1) {
				WebElement MemberNames =	FindElement("EmailIdList" , MembersLocators , size);

				String MemberNamesList = 	GetTextFromTheElement(MemberNames);
				if(MemberNamesList.equalsIgnoreCase(ReadFrom.Excel(0, 1 , ReadFrom.Login))) {
					Print("All members are deleted except origin member : " + MemberNamesList);
					ExtentCucumberAdapter.addTestStepLog("All members are deleted except origin member : " + MemberNamesList);
				}
			}
			else {
				
				PrintError("All members are not deleted");
				ExtentCucumberAdapter.addTestStepLog("All members are not deleted");
			}



		} catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}
}

