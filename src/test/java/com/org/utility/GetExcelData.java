package com.org.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {

	public static Object[][] getData(String SheetName, String FilePath) throws IOException, InvalidFormatException {
		File TestData = new File(FilePath);
		try (XSSFWorkbook workbook = new XSSFWorkbook(TestData)) {
			XSSFSheet Sheet = workbook.getSheet(SheetName);
			int TotalRows = Sheet.getPhysicalNumberOfRows();
			Object[][] DataSet = new Object[TotalRows-1][2];
			
			System.out.println(TotalRows);
			for(int i=1, j=0; i<TotalRows;i++, j++)
			{
				Row row= Sheet.getRow(i);	
				if(row==null) 
				{
					TotalRows++;
					j--;
				}
				else {
					Cell cell1 =row.getCell(0);
					Cell cell2 =row.getCell(1);
					
					if(cell1!=null&&cell2!=null)
					{
						DataSet[j][0]=cell1.getStringCellValue();
						DataSet[j][1]=cell2.getStringCellValue();
					}
					else if(cell1==null&&cell2!=null) 
					{
						DataSet[j][0]="";
						DataSet[j][1]=cell2.getStringCellValue();
					}
					else if (cell2==null && cell1!=null) 
					{
						DataSet[j][0]=cell1.getStringCellValue();
						DataSet[j][1]="";
					}
					}
}
			return DataSet;
		}
}
}
