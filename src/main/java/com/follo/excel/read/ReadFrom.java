package com.follo.excel.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.follo.baseclass.Baseclass;

public class ReadFrom extends Baseclass {


	//public static String ExcelData = "./src/test/resources/ExcelFile/Follo_WebApp_Datas.xlsx";
	public static String ExcelData = "./TestData/Follo_WebApp_Datas.xlsx" ;
	public static  int rowcount;
	public static  int colcount;
	public static XSSFWorkbook Workbook;
	public static XSSFSheet Sheet;
	
	public static String Register = "Register";
	public static String Login = "Login"; 
	public static String AddDFOW = "AddDFOW";
	public static String DeleteDFOW = "DeleteDFOW";
	public static String EditDFOW  = "EditDFOW";
	public static String SearchDFOW  = "SearchDfow";
	public static String AddCompany  = "AddCompany";
	public static String AddCompanyDfow  = "AddCompanyDfow";
	public static String SearchCompany  = "SearchCompany";
	public static String DeleteCompany  = "DeleteCompany";
	public static String EditCompanyDetails  = "EditCompanyDetails";
	public static String FilterCompany  = "FilterCompany";  
	public static String InviteMembers  = "InviteMembers";
	public static String SearchMembers  = "SearchMembers";
	public static String FilterMembers  = "FilterMembers";
	public static String DeleteMembers  = "DeleteMembers";
	public static String EditMembers  = "EditMembers";
	public static String AddGates  = "AddGates"; 
	public static String EditGates  = "EditGates"; 
	public static String DeleteGates  = "DeleteGates"; 
	public static String SearchGates  = "SearchGates"; 
	public static String AddEquipment  = "AddEquipment";
	public static String EditEquipment  = "EditEquipment";
	public static String FilterEquipment  = "FilterEquipment";
	public static String SearchEquipment  = "SearchEquipment";
	public static String DeleteEquipment  = "DeleteEquipment";
	
	
	



	public static String UploadDfowFile = "D:/DFOW_Export_1648727904962.xlsx";




	public static String Excel(int row, int col, String sheetname) throws Throwable {


		File file = new File(ExcelData);
		FileInputStream fileread = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fileread);
		Sheet sheet = workbook.getSheet(sheetname);
		Row rownumber = sheet.getRow(row);
		Cell value = rownumber.getCell(col);
		String data = value.toString();
		return data;
	}

	public static  int DynamicExcel( String Sheetname) throws Throwable {

		FileInputStream fileread = new FileInputStream(ExcelData);

		Workbook = new XSSFWorkbook(fileread);
		Sheet = Workbook.getSheet(Sheetname);
		rowcount = Sheet.getLastRowNum();
		return rowcount;

	}
}



