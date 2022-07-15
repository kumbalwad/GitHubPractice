package com.qa.pages;

import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static FileInputStream fis = null;
	public static Workbook wb = null;

	public static void readxlsx() {

		try {
			fis = new FileInputStream(
					"C:\\Users\\akash\\Selenium\\Testing\\src\\main\\java\\com\\qa\\confg\\Book1.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}
		Sheet sh = wb.getSheetAt(0);

		String stringValue = sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println(stringValue);

		int intValue =(int) sh.getRow(1).getCell(3).getNumericCellValue();
		System.out.println(intValue);

		Date dateValue = sh.getRow(1).getCell(4).getDateCellValue();
		System.out.println(dateValue);

	}

	public static void readExcel() {

		try {
			fis = new FileInputStream(
					"C:\\Users\\akash\\Selenium\\Testing\\src\\main\\java\\com\\qa\\confg\\Book1.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}

		Sheet sh = wb.getSheet("Sheet2");

		int rowCount = sh.getLastRowNum();

		for (int i = 0; i <= rowCount; i++) {

			int colCount = sh.getRow(i).getLastCellNum();

			for (int j = 0; j < colCount; j++) {
				try {
					String stringValue = sh.getRow(i).getCell(j).getStringCellValue();
					System.out.print(stringValue + " ");
				} catch (Exception e) { 
					try {
						int intValue = (int) sh.getRow(i).getCell(j).getNumericCellValue();
						System.out.print(intValue + " ");
					} catch (Exception e1) {
						Date dateValue = sh.getRow(i).getCell(j).getDateCellValue();
						System.out.print(dateValue);
					}
				}
			}
			System.out.println();
		}
	}

	public static void readExcelInLoop() {

		try {
			fis = new FileInputStream(
					"C:\\Users\\akash\\Selenium\\Testing\\src\\main\\java\\com\\qa\\confg\\Book1.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}

		Sheet sh = wb.getSheet("Sheet2");

		int rowCount = sh.getLastRowNum();

		for (int i = 0; i <= rowCount; i++) {

			int colCount = sh.getRow(i).getLastCellNum();

			for (int j = 0; j < colCount; j++) {

				if (sh.getRow(i).getCell(j).getStringCellValue().contains("")) {

					String stringValue = sh.getRow(i).getCell(j).getStringCellValue();
					System.out.print(stringValue + " ");

				} else {
					try {
						int intvalue = (int) sh.getRow(i).getCell(j).getNumericCellValue();
						System.out.print(intvalue + " ");
					} catch (Exception e) {
						Date dateValue = sh.getRow(i).getCell(j).getDateCellValue();
						System.out.print(dateValue);
					}
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		readExcel();
	}
}
