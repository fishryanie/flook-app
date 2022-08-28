package com.finaltest.selenium.helpers;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHelper {

    private static Workbook workbook;
    private static Sheet sheet;
    private static Row row;

    public static Object[][] readOrderListFromExcelFile(String path) {
        Object[][] data;
        try {
            FileInputStream file = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet("Sheet1");
            row = sheet.getRow(0);
            int rowNum = sheet.getLastRowNum();
            int colNum = row.getLastCellNum();

            data = new Object[rowNum][colNum];
            for (int i = 1; i <= rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
                        data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                    } else if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC){
                        data[i-1][j] = ((int) sheet.getRow(i).getCell(j).getNumericCellValue()) + "";
                    } else {
                        data[i-1][j] = "";
                    }
                }
            }
            workbook.close();
            return data;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}