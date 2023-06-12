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

import Pages.flightStatusPage;
import base.baseClass;

public class flightStatusTestCase extends baseClass {
	
	@Test(dataProvider = "getFromExcel")
	public void flightStatuspageTestCase(String fromTxtBox,String ToTxtBox, String flightNum ) throws Exception {
		flightStatusPage page = new flightStatusPage();
    page.flightStatus(fromTxtBox,ToTxtBox,flightNum);
    Thread.sleep(2000);
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\flightstatuspage.png"));
    WebElement result = driver.findElement(By.xpath("//div[contains(text(),'All times displayed are the selected airport local time')]"));
    Assert.assertEquals("All times displayed are the selected airport local time", result.getText());
    Thread.sleep(2000);
 
}

@DataProvider(name = "getFromExcel")
public Object[][] getFromExcel() throws Exception{
	String sheetName = "Sheet7";
	Object[][] data = dataReader(sheetName);
	return data;
}


}
