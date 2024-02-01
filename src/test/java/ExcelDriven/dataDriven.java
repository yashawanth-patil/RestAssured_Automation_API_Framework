package ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	static String sheetnamesof = " ";
	
	
	
	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String TestCasesname, String sheetName) throws IOException {
		
		ArrayList<String> a = new ArrayList<>();
		//file inputstream argument
		FileInputStream fis = new FileInputStream("Y:\\Yashvanth patil learnings\\Eclipse Workspace\\API_Framework\\Demo_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
		int sheets = workbook.getNumberOfSheets(); // iterate through the each sheet names which are present in file
		for(int i=0; i<sheets; i++)
		{
			XSSFSheet nameofSheet = workbook.getSheetAt(i);
			// identify testcases column by scanning the entire 1st row
			String names = nameofSheet.getSheetName();
		//	sheetnamesof =  names ;
		//	System.out.println(sheetnamesof);
			
			if(names.equalsIgnoreCase(sheetName)) // search for the required sheet name in the excel file which we are passing
			{
				Iterator<Row> rows = nameofSheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cells =firstrow.cellIterator();
				
				int k=0;
				int coulmn = 0;
				while(cells.hasNext()) // if next cell data is present it move inside into the loop
				{
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) // row value of the cell at 0th index means test case name which have test data
					{
						coulmn = k;
					}
					k++;
				}
				System.out.println(coulmn);
				
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(coulmn).getStringCellValue().equalsIgnoreCase(TestCasesname))
					{
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();    // checking the cell value type
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
								
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue())); // converting the cell value of numeric to text
								
							}
							
							
						}
						
					}
					
				}
				
			}
			
		}
		return a;
		
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
	}
}
