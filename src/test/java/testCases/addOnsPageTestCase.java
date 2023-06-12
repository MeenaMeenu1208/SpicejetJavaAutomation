package testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.addOnsPage;
import Pages.oneWayTrip;
import Pages.passengerPage;
import base.baseClass;

public class addOnsPageTestCase extends baseClass {

	@Test
	public void addOnsPageTC() throws Exception {
	passengerPage page = new passengerPage();
	loginPageTestCases ltc = new loginPageTestCases();
	oneWayTrip page2 = new oneWayTrip();
	addOnsPage page3 = new addOnsPage();
	Thread.sleep(4000);
	ltc.loginPagetestcases("9751862387", "Meenu@120899");
	Thread.sleep(4000);
	page2.oneWay("cjb","del");
	Thread.sleep(4000);
    page.passenger("Meena","Mani","9751862387","meenameenu1313@gmail.com","Coimbatore");
	page3.addOns();
	Thread.sleep(8000);
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\addOnpage.png"));
    WebElement result = driver.findElement(By.xpath("//div[contains(text(),'Payment Methods')]"));
    Assert.assertEquals("Payment Methods", result.getText());
	
}
}