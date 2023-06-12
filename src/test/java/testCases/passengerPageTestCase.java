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

import Pages.oneWayTrip;
import Pages.passengerPage;
import base.baseClass;

public class passengerPageTestCase extends baseClass {

	
	@Test(dataProvider = "getFromExcel")
	public void passengerPgeTestCase(String fname,String lname, String MbNumber, String email, String TownCity ) throws Exception {
	passengerPage page = new passengerPage();
	loginPageTestCases ltc = new loginPageTestCases();
	oneWayTrip page2 = new oneWayTrip();
	Thread.sleep(4000);
	ltc.loginPagetestcases("9751862387", "Meenu@120899");
	Thread.sleep(4000);
	page2.oneWay("cjb","del");
	Thread.sleep(3000);
    page.passenger(fname,lname,MbNumber,email,TownCity);
    Thread.sleep(4000);
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\passengerpage.png"));
    WebElement result = driver.findElement(By.xpath("//div [contains(text(),'Add-ons')]"));
    Assert.assertEquals("Add-ons", result.getText());
}

@DataProvider(name = "getFromExcel")
public Object[][] getFromExcel() throws Exception{
	String sheetName = "Sheet4";
	Object[][] data = dataReader(sheetName);
	return data;
}
}
