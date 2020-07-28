/*package com.howtodoinjava.demo.controller;

//import org.apache.commons.collections4.map.LinkedMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelApiTest {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public int rows;
	Map<Integer, String> map = new LinkedHashMap<Integer, String>();

	public ExcelApiTest(String xlFilePath) throws Exception {
		File excel = new File("D:\\Users\\1017216\\GE-SalesReport1.xlsx");
		fis = new FileInputStream(excel);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public Map<Integer, String> getCellData() {
		try {
			int col_Num = -1;
			sheet = workbook.getSheet("Sheet1");
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals("Project Name")) {
					col_Num = i;
					break;
				}
			}

			// row = sheet.getRow(0);
			rows = sheet.getPhysicalNumberOfRows();

			for (int i = 0; i < rows; i++) {
				row = sheet.getRow(i);
				cell = row.getCell(col_Num);
				if (cell.getCellTypeEnum() == CellType.STRING) {
					map.put(i, cell.getStringCellValue());
				}
				if (cell.getCellTypeEnum() == CellType.BLANK) {
					map.put(i, " ");
				}

				
				 * else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum()
				 * == CellType.FORMULA) { String cellValue =
				 * String.valueOf(cell.getNumericCellValue());
				 * if(HSSFDateUtil.isCellDateFormatted(cell)) { DateFormat df = new
				 * SimpleDateFormat("dd/MM/yy"); Date date = cell.getDateCellValue(); cellValue
				 * = df.format(date); } return cellValue; }else if(cell.getCellTypeEnum() ==
				 * CellType.BLANK) return ""; else return
				 * String.valueOf(cell.getBooleanCellValue());
				 

			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_MAP;
		}
	}

	public static void main(String[] args) throws Exception {
		ExcelApiTest ex = new ExcelApiTest("mahi");
		Map<Integer, String> columnvalue = ex.getCellData();
		System.out.println("..............." + columnvalue);

	}
}*/