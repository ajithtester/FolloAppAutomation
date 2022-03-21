package com.follo.excel.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.follo.baseclass.Baseclass;

public class ReadFrom extends Baseclass {

	public static String ExcelData = "./src/main/java/com/follo/excelfile/Follo_WebApp_Datas.xlsx";
	public static  int rowcount;
	public static XSSFSheet Sheet;
	public static String AddDFOW = "AddDFOW";
	public static String DeleteDFOW = "DeleteDFOW";
	public static String EditDFOW  = "EditDFOW";
	public static String SearchDFOW  = "SearchDfow";
	
	

	public static String UploadDfowFile = "C:\\Users\\ajithkumar.j\\Downloads\\DFOW.xlsx";
	



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

		XSSFWorkbook workbook = new XSSFWorkbook(fileread);
		Sheet = workbook.getSheet(Sheetname);
		rowcount = Sheet.getLastRowNum();
		return rowcount;


	}




}
