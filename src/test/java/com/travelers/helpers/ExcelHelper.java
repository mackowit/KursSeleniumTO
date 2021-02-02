package com.travelers.helpers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelHelper {

    public static Object[][] readExcelFile(File file) throws IOException{

        InputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);  //dla plików .xlsx
        //HSSFWorkbook workbook = new HSSFWorkbook(inputStream);    //dla plików .xls
        Sheet sheet = workbook.getSheetAt(0);
        int rowNumber = sheet.getLastRowNum();
        System.out.println(rowNumber);
        int colNumber = sheet.getRow(0).getLastCellNum();
        System.out.println(colNumber);
        String[][] data = new String[rowNumber][colNumber];

        for (int i = 0; i < rowNumber; i++) {
            Row row = sheet.getRow(i+1);
            for(int j = 0; j < row.getLastCellNum(); j++) {
                data[i][j] = row.getCell(j).getStringCellValue();
            }
        }

        return data;
        /*Iterator<Row> iterator = sheet.rowIterator();

        while(iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getCellType().equals(CellType.STRING)) {
                    System.out.println(cell.getStringCellValue());
                } else if (cell.getCellType().equals(CellType.NUMERIC)) {
                    System.out.println(cell.getNumericCellValue());
                }
                }
        }*/
    }

    /*public static void main(String[] args) throws IOException {
        Object [][] data = readExcelFile(new File("src/main/resources/Dane.xlsx"));
        System.out.println(data[0][0]);
    }*/
}
