package testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.checkInPage;
import base.baseClass;

public class checkInpageTestCase extends baseClass {
	
		@Test(dataProvider = "getFromExcel")
		public void checkInTestCase(String ticketRPNRNum,String emailRLastName ) throws Exception {
		checkInPage page = new checkInPage();
	    page.checkIn(ticketRPNRNum,emailRLastName);
	    Thread.sleep(4000);
	    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\checkinpage.png"));
		//boolean b = driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 css-cens5h r-jwli3a')]")).isDisplayed();
		//System.out.println(b);
	    WebElement result = driver.findElement(By.xpath("//div[contains(text(),'check-in')]"));
	    Assert.assertEquals("Check-in", result.getText());
		
	}

	@DataProvider(name = "getFromExcel")
	public Object[][] getFromExcel() throws Exception{
		String sheetName = "Sheet6";
		Object[][] data = dataReader(sheetName);
		return data;
	}

}
