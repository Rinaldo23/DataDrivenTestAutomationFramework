package com.rb.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rb.base.BaseClass;

/**
 * Utility class for reading from and writing to Excel files using Apache POI.
 */
public class ExcelUtility extends BaseClass {

	DataGenerator dg = new DataGenerator();

	/**
	 * Reads data from an Excel sheet.
	 * 
	 * @return An array of strings containing the read data.
	 * @throws Exception
	 * @throws Exception if any error occurs during reading.
	 */
	public String[] readExcelData() throws Exception {

		File excelFile = new File(prop.getProperty("excelFilePath"));
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("userDetails");

		String[] list = new String[2];
		// Generate a random row number within the valid range
		int NoOfRows = sheet.getLastRowNum();
		int randomRowNumber;
		if (NoOfRows == 1) {
			randomRowNumber = NoOfRows;
		} else {
			randomRowNumber = dg.generateRandomNumber(1, sheet.getLastRowNum());
		}

		DataFormatter df = new DataFormatter();

		// Read specific cell values from the randomly selected row
		list[0] = df.formatCellValue(sheet.getRow(randomRowNumber).getCell(2));
		list[1] = df.formatCellValue(sheet.getRow(randomRowNumber).getCell(5));

		fis.close();
		workbook.close();
		return list;

	}

	/**
	 * Writes data to an Excel sheet.
	 * 
	 * @param data An array of strings containing the data to be written.
	 * @throws Exception if any error occurs during writing.
	 */
	public void writeExcelData(List<String> data) throws Exception {

		File excelFile = new File(prop.getProperty("excelFilePath"));
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("userDetails");

		// If sheet does not exist, create a new one
		if (sheet == null) {
			sheet = workbook.createSheet("userDetails");
		}

		int rowNum = sheet.getLastRowNum() + 1;

		// Create a new row and write data to each cell in that row
		XSSFRow row = sheet.createRow(rowNum);
		for (int i = 0; i < data.size(); i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(data.get(i));
		}

		fis.close();

		try (FileOutputStream fileOut = new FileOutputStream(excelFile)) {
			workbook.write(fileOut);
		}

		workbook.close();
	}
}
