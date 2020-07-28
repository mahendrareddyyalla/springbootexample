/*package com.howtodoinjava.demo.controller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.howtodoinjava.demo.model.Student;


public class XLSXReaderWriter {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

        try {
            File excel = new File("D:\\Users\\1017216\\GE-SalesReport1.xlsx");
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(fis);
            XSSFSheet xSSFSheet = xSSFWorkbook.getSheetAt(0);
            XLSXReaderWriter.print(xSSFSheet);
        }
        catch(FileNotFoundException ex) {
        	
        }
    }

        public static void print(XSSFSheet sheet) {
        	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+sheet.getFirstHeader().toString());
        	Map<Integer,String> map=new LinkedMap<Integer,String>();
        	Iterator<Row> itr = sheet.iterator();
        	

            // Iterating over Excel file in Java
            while (itr.hasNext()) {
                Row row = itr.next();
                System.out.println(row.getRowNum());
                System.out.println();

                // Iterating over each column of Excel file
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                	Cell cell = cellIterator.next();
                	//System.out.println("[[[[[[]]]]]]]]]]]]]][[{{{{{{{]]]]]]]]]]"+cell.getRichStringCellValue());
                	//System.out.println("[[[[[[]]]]]]]]]]]]]][[{{{{{{{]]]]]]]]]]======================"+cell.getStringCellValue());
                	int i=cell.getColumnIndex();
                	if(cell.getCellTypeEnum() == CellType.STRING){
                		System.out.print(cell.getStringCellValue() + "\n");
                	}
                	if(cell.getCellTypeEnum() == CellType.NUMERIC){
                		System.out.print(cell.getNumericCellValue() + "\n");
                	}
                	if(cell.getCellTypeEnum() == CellType.BOOLEAN){
                		System.out.print(cell.getBooleanCellValue() + "\n");
                	}
                	
            //return currentRow.createCell(cellIndex++);
        }
            }
        }
    }
        
   
    */