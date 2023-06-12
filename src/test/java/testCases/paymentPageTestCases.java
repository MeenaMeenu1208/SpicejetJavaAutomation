package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.addOnsPage;
import Pages.oneWayTrip;
import Pages.passengerPage;
import Pages.payementPage;
import base.baseClass;

public class paymentPageTestCases extends baseClass{
	@Test(dataProvider = "getFromExcel")
	public void payMentTC(String cardNumber,String nameonCard,String expMonth, String expYear,String secCode ) throws Exception{
		passengerPage page = new passengerPage();
		loginPageTestCases ltc = new loginPageTestCases();
		oneWayTrip page2 = new oneWayTrip();
		addOnsPage page3 = new addOnsPage();
		payementPage page4 = new payementPage();
		
		Thread.sleep(4000);
		ltc.loginPagetestcases("9751862387", "Meenu@120899");
		Thread.sleep(4000);
		page2.oneWay("cjb","del");
		Thread.sleep(4000);
	    page.passenger("Meena","Mani","9751862387","meenameenu1313@gmail.com","Coimbatore");
		System.out.println(driver.getTitle());
		page3.addOns();
		Thread.sleep(7000);
		page4.payMent(cardNumber, nameonCard, expMonth, expYear, secCode);
		Thread.sleep(2000);
	    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\paymentpage.png"));
		Thread.sleep(2000);
		
}
	
	@DataProvider(name = "getFromExcel")
	public Object[][] getFromExcel() throws Exception{
		String sheetName = "Sheet5";
		Object[][] data = dataReader(sheetName);
		return data;
	}
}
