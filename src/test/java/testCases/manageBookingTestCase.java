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

import Pages.manageBookingPage;
import base.baseClass;

public class manageBookingTestCase extends baseClass {
	
	@Test(dataProvider = "getFromExcel")
	public void manageBookingpageTestCase(String PNRorTicketNum,String emailRLastname ) throws Exception {
		manageBookingPage page = new manageBookingPage();
    page.manageBooking(PNRorTicketNum,emailRLastname);
    Thread.sleep(2000);
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\managebookingpage.png"));
    WebElement result = driver.findElement(By.xpath("//div[contains(text(),'manage booking')]"));
    Assert.assertEquals("Manage Booking", result.getText());
}

@DataProvider(name = "getFromExcel")
public Object[][] getFromExcel() throws Exception{
	String sheetName = "Sheet8";
	Object[][] data = dataReader(sheetName);
	return data;
}


}
