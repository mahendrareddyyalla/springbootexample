/*
package com.howtodoinjava.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.demo.model.Student;

import io.swagger.annotations.Api;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*//**
 * {@link Controller} for downloading the an Excel Spreadsheet.
 *//*
@Api
@Controller
@RequestMapping(value = "download")
public class PlanTasksDownloadController {

    *//**
     * {@link Logger} to be used.
     *//*
    //private static final Logger LOGGER = LoggerFactory.getLogger(PlanTasksDownloadController.class);

    *//**
     * {@link ObjectMapper} to be used to pretty print output.
     *//*
    //private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadTasks() throws IOException, SQLException {

        // Build the Work Book Helper.
        WorkbookHelper workbookHelper = new WorkbookHelper("BNSF", "ALLIANCE", 3456788);
        
        Student s1=new Student("Sajal", "IV", "India");
        workbookHelper.newRow();
        

        // Add the Values from the Result Set Row to the Work Book.
        workbookHelper.addLongCell(s1, "WORK_ORDER_ID");
        workbookHelper.addLongCell(s1, "WORK_ORDER_TASK_ID");

        // Build the Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                String.format("attachment; filename=%s-%s-%d.xlsx", "BNSF", "Alliance", 21887723));
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        // Flush the Response.

        return new ResponseEntity<>(workbookHelper.getBytes(), headers, HttpStatus.OK);
    }

    *//**
     * Utility Class to help with the Work Book.
     *//*
    private class WorkbookHelper {

        *//**
         * The {@link XSSFWorkbook} we are building.
         *//*
        private XSSFWorkbook workbook;

        *//**
         * The {@link XSSFSheet} we are building.
         *//*
        private XSSFSheet sheet;

        *//**
         * The Current Row.
         *//*
        private XSSFRow currentRow;

        *//**
         * The Current Row Index.
         *//*
        private int rowIndex;

        *//**
         * The Current Cell Index.
         *//*
        private int cellIndex;

        *//**
         * The {@link XSSFCellStyle} for the Header.
         *//*
        private XSSFCellStyle headerCellStyle;

        *//**
         * The {@link XSSFCellStyle} to be used for JSON Cells.
         *//*
        //private XSSFCellStyle jsonCellStyle;

        *//**
         * The Date Format to be used to display Dates.
         *//*
        private DateFormat dateFormat;

        *//**
         * Initializes a new instance of the Workbook Helper.
         *
         * @param clientId   The Id for the Client.
         * @param terminalId The Id for the Terminal.
         * @param planId     The Id for the Plan.
         *//*
        private WorkbookHelper(String clientId, String terminalId, long planId) {

            // Build the Workbook.
            this.workbook = new XSSFWorkbook();
            this.sheet = workbook.createSheet("mahi");

            // Create a Font to be used for the Header
            XSSFFont headerFont = workbook.createFont();
            headerFont.setBold(true);

            // Set the Header Cell Style.
            this.headerCellStyle = workbook.createCellStyle();
            this.headerCellStyle.setFont(headerFont);

            // Set the JSON Cell Style.
            //this.jsonCellStyle = workbook.createCellStyle();
            //this.jsonCellStyle.setShrinkToFit(true);

            // Set the Date Format to be used.
            this.dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss zzz");
            this.dateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));

            // Write the Header Rows.
            createHeaderRow();

            // Freeze the First Row.
            //this.sheet.createFreezePane(0, 1);

            // Set the Filters.
            //this.sheet.setAutoFilter(new CellRangeAddress(0, 1, 0, cellIndex - 1));
        }

        *//**
         * Retrieve the Next {@link XSSFCell} to be used.
         *
         * @return Next {@link XSSFCell} to be used.
         *//*
        private XSSFCell getNextCell() {
            return currentRow.createCell(cellIndex++);
        }

        *//**
         * Adds an {@link CellType#BLANK} {@link XSSFCell} to the {@link #currentRow}.
         *//*
        private void addEmptyCell() {
            getNextCell().setCellType(CellType.BLANK);
        }
        private void addNumericCell(String value, boolean wasNull) {
            if (wasNull) {
                addEmptyCell();
            } else {
            	System.out.println("student name value" +value);
                XSSFCell cell = getNextCell();
                cell.setCellType(CellType.STRING);
                System.out.println("student name trim value" +value.trim());
                cell.setCellValue(value.trim());
            }
        }
        private void addLongCell(Student rst, String columnName) throws SQLException {
        	System.out.println("student name" +rst.getName());
            addNumericCell(rst.getName(), false);
        }
        private byte[] getBytes() throws IOException {
            // Before writing, set the sheet to auto size
            for (int i = 0; i < cellIndex; i++) {
                if (i == 31 || i == 32) {
                    continue;
                }
                sheet.autoSizeColumn(i);
            }

            // Get the Bytes for the Workbook
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                workbook.write(bos);
                return bos.toByteArray();
            }
        }

        *//**
         * Creates the Header Row for the Worksheet.
         *//*
        private void createHeaderRow() {
            // Create a new Row.
            newRow();

            // Add the Header Cells
            addHeaderCell("Work Order ID");
            addHeaderCell("Task ID");
        }

        *//**
         * Utility method to add a Header Cell.
         *
         * @param header The Name fo rhte Header.
         *//*
        private void addHeaderCell(String header) {
            XSSFCell headerCell = currentRow.createCell(cellIndex++);
            headerCell.setCellValue(header);
            headerCell.setCellStyle(headerCellStyle);
        }

        *//**
         * Creates a new {@link XSSFRow} within the {@link XSSFSheet}.
         *//*
        private void newRow() {
            currentRow = sheet.createRow(rowIndex++);
            cellIndex = 0;
        }
    }
}
*/