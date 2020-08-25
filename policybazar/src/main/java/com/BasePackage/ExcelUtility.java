package com.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
		
	public void writeToExcel(String[] stringArray)
	{
		//Load workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Load sheet - Here we are loading first sheet only
        XSSFSheet sheet = workbook.createSheet("sheet1"); 
    
        int rownum = 0; 
        for (String s : stringArray) { 
            Row row = sheet.createRow(rownum++); 
            int cellnum = 0; 
                Cell cell = row.createCell(cellnum++); 
                    cell.setCellValue((String)s); 
        }
        try { 
        	//here we need to specify where you want to save file
            FileOutputStream out = new FileOutputStream(new File("filename.xlsx")); 
            
            //finally write content
            workbook.write(out); 
            
            //close the file
            out.close(); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        
	}
	public String[] readFromExcel() throws IOException
	{
		//path of file
		FileInputStream fis = new FileInputStream("Book.xlsx");
		
		//load the file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		String[] in = new String[3];
		
		int rows = sheet.getLastRowNum();
		
		//Create a loop over all the rows of excel file to read it
		for(int i=0;i<=rows;i++)
		{
			//Get the row from the sheet
			Row r = sheet.getRow(i);
			//
			in[i] = r.getCell(0).getStringCellValue();
			
		}
		return in;
		
	}
}