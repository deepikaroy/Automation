package generics;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class UtilityLib 
{
	public static String getPropertyValue(String path, String key) 
	{
		/**
		 * reads the values on the basis of keys from the property file(config.properties)
		 * @author munshid
		 * @parameters path, key
		 */
		String v = "";
		try
		{
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(key);
		}
		catch(Exception e)
		{
			Reporter.log("Some exception occured in reading the property from config file", true);
		}
		return v;
	}
	
	public static void getScreenShot(WebDriver driver, String path) 
	{
		/**
		 * takes the screenshot of the web page
		 * @author munshid
		 * @parameters driver, path
		 */
		try
		{
			TakesScreenshot t = (TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(path));
		}
		catch(Exception e)
		{
			Reporter.log("Some error occured in taking the screenshot", true);
		}
	}

	public static void getScreenShot(String path) 
	{
		/**
		 * takes the screenshot of the desktop
		 * @author munshid
		 * @parameter path
		 */
		try
		{
			Robot r = new Robot();
			java.awt.Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage img = r.createScreenCapture(new Rectangle(d));
			ImageIO.write(img, "png", new File(path));
		}
		catch(Exception e)
		{
			Reporter.log("Some error occured in taking the screenshot", true);
		}
	}

	public static String now()
	{
		/**
		 * gives the current date time in YYYYMMYY_hhmmss format. 
		 * It is appended to the filename of the screenshots taken.
		 */
		SimpleDateFormat s = new SimpleDateFormat("YYYYMMYY_hhmmss");
		return s.format(new Date());
	}

	public static String getCellValue(String path, String sheet, int r, int c) 
	{
		/**
		 * reading the cell content of the input excel sheet
		 */
		String v = "";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			Reporter.log("Some error occured while reading the value from excel sheet", true);
		}
		return v;
	}

	public static int getRowCount(String path, String sheet) 
	{
		/**
		 * gives the count of records present in the input file
		 */
		int r = 0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			r = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			Reporter.log("Some error occured while fetching the total number of input records in excel sheet", true);
		}
		return r;
	}


}
