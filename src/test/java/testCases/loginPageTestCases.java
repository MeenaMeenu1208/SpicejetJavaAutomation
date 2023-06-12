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

import Pages.loginPage;
import base.baseClass;

public class loginPageTestCases extends baseClass{
		@Test(dataProvider = "getFromExcel")
		public void loginPagetestcases(String mobNumb,String Passwd ) throws Exception {
		loginPage page = new loginPage();
	    page.logIn(mobNumb,Passwd);
	    Thread.sleep(4000);
	    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\loginpage.png"));
	    WebElement result = driver.findElement(By.xpath("//div[contains(text(),'Hi Meena')]"));
	    Assert.assertEquals("Hi Meena", result.getText());
	}

	@DataProvider(name = "getFromExcel")
	public Object[][] getFromExcel() throws Exception{
		String sheetName = "Sheet2";
		Object[][] data = dataReader(sheetName);
		return data;
	}
	}


