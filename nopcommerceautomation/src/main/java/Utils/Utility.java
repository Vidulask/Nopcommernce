package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	private static WebDriver driver;
	
	public static void captureScreenshot(String TestID)throws IOException{
		
		SimpleDateFormat mydate = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
		
		Date date = new Date();
		
		String d =  mydate.format(date);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Destination =new File ("E:\\selenium screenshot");
		
		FileHandler.copy(src, Destination);
	}
	
	public static String getDataFromExcel(String sheet , int row , int cell ) throws EncryptedDocumentException, IOException
	   {
		String path = "C:\\Users\\welcome\\Desktop\\practicsexcel.xlsx";
		
		FileInputStream File = new FileInputStream(path);
		
		Cell cellNum = WorkbookFactory.create(File).getSheet(sheet).getRow(row).getCell(cell);
		 
		try 
		{
			data = cellNum.getStringCellValue();
		}
		catch(Exception e)
		{
			int a = (int)cellNum.getNumericCellValue();   //upcast double to int
			String str = Integer.toString(a);          //covert int to string
			data = str;
		}
		
		return data;
	}
}
	


