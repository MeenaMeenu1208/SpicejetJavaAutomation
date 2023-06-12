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

import Pages.roundTripPage;
import base.baseClass;


public class roundTripePageTestCase extends baseClass {
	@Test(dataProvider = "getFromExcel")
	public void oneWayTripTestcases(String fromTxtBox,String toTxtBox ) throws Exception {
	roundTripPage page = new roundTripPage();
	loginPageTestCases ltc = new loginPageTestCases();
	ltc.loginPagetestcases("9751862387", "Meenu@120899");
	Thread.sleep(4000);
    page.roundTrip(fromTxtBox,toTxtBox);
    Thread.sleep(2000);
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\Roundtrippage.png"));
	WebElement result = driver.findElement(By.xpath("//div [contains(text(),'Passenger Information')]"));
	Assert.assertEquals("Passenger Information", result.getText());
}

@DataProvider(name = "getFromExcel")
public Object[][] getFromExcel() throws Exception{
	String sheetName = "Sheet3";
	Object[][] data = dataReader(sheetName);
	return data;
}

}
