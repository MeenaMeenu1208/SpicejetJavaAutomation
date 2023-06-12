package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class utils {
	
public static WebDriver driver;
public static String dateandtime;

	
	
	public static String getpropvalue(String key) {
		String value = null;
		try {
			Properties prop = new Properties();
			File file = new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\config.properties");
			FileInputStream ip = new FileInputStream(file);
			prop.load(ip);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public String addScreenShot(WebDriver d, String imgpath) throws Exception
	{
		String image = "";
		FileInputStream imageFile;
		try
		{
			String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+imgpath+".png";
			File imgfile = new File(capture(d, dest));
			imageFile = new FileInputStream(dest);
            byte imageData[] = new byte[(int) imgfile.length()];
            imageFile.read(imageData);
            byte[] base64EncodedByteArray = Base64.encodeBase64(imageData);
            image = new String(base64EncodedByteArray);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return "data:image/png;base64,"+image;
	}
	
	
	
	public static String capture(WebDriver driver,String dest) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
       
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
	
	//Launching browser
	public static void browserLaunch(String name) {

		switch (name) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No valid options given choosing the default browser");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	//launching URL
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	// Check for element availability
		public static boolean waitforme(WebElement element) {
			boolean flag = false;

			try {

				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.visibilityOf(element));
				//test.log(Status.PASS, id + "is available");
				flag = true;
			} catch (Exception e) {
				System.out
						.println("Error occured while waiting for the element :" + "with exception " + e.getMessage());
				//test.log(Status.FAIL, id + "is not available");

			}
			return flag;
		}
		
		// Click a Web Element

		public void clickElement(WebElement element) {
			try {

				if (waitforme(element)) {
					element.click();
					//test.log(Status.PASS, id + "is clicked ");
				}
			} catch (Exception e) {
				System.out.println("Error in clicking the webelement :" + e.getMessage());
				//test.log(Status.FAIL, "Failed to click the element :" + id);
			}

		}
		//Send keys to the textbox
		public void typeText(WebElement element,String txt) {
			try {

				if (waitforme(element)) {
					element.sendKeys(txt);
					//test.log(Status.PASS, id + "is clicked ");
				}
			} catch (Exception e) {
				System.out.println("Error in Typing the webelement :" + e.getMessage());
				//test.log(Status.FAIL, "Failed to click the element :" + id);
			}

		}
		
		public String[][] dataReader(String sheetName) throws IOException {
	        String[][] data = null;
	        try {
	        	File f  =new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ExcelData\\SpiceJetExcelData.xlsx");
	            FileInputStream fis = new FileInputStream(f);
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            XSSFRow row = sheet.getRow(0);
	            int noOfRows = sheet.getPhysicalNumberOfRows();
	            int noOfCols = row.getLastCellNum();
	            XSSFCell cell;
	            data = new String[noOfRows - 1][noOfCols];
	 
	            for (int i = 1; i < noOfRows; i++) {
	                for (int j = 0; j < noOfCols; j++) {
	                    row = sheet.getRow(i);
	                    cell = row.getCell(j);
	                    data[i - 1][j] = cell.getStringCellValue();
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("The exception is: " + e.getMessage());
	        }
	        return data;
	    }
		
		public void windowHandles() {
			String parent=driver.getWindowHandle();

			Set<String>s=driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);

			}
		}

}
}
