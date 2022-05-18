package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
	
		
		public static String[][] readData(String fileName)
		{

			XSSFWorkbook objBook = null;
			XSSFSheet    objSheet;

			try
			{
				System.out.println("./data/"+fileName+".xlsx");
				objBook= new XSSFWorkbook("./data/"+fileName+".xlsx");
			}catch(Exception e)
			{
				System.out.println("Exception in reading the file from the path");
			}

			objSheet = objBook.getSheet("Sheet1");
			int rowCount=objSheet.getLastRowNum()- objSheet.getFirstRowNum();

			int colCount=objSheet.getRow(0).getLastCellNum();

	 		String[][] data = new String[rowCount][colCount];

			for(int i=1;i<=rowCount;i++)
			{
				for(int j=0;j<colCount;j++)
				{
					//System.out.println(objSheet.getRow(i).getCell(j).getStringCellValue());
					data[i-1][j]=objSheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		
			try {
				objBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		}
}
