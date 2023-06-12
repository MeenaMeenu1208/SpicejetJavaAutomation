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

import Pages.signupPage;
import base.baseClass;

public class signupPageTestcase extends baseClass {
	@Test(dataProvider = "getFromExcel")
	public void signUppagetestcases(String fstName,String lstName,String dob,String mobNumber,String email,String nPassword, String cPasswrd ) throws Exception {
	signupPage page = new signupPage();
    page.SignUp(fstName, lstName, dob, mobNumber, email, nPassword, cPasswrd);
    Thread.sleep(2000);
    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f, new File("E:\\Meena\\Workspace\\workspace\\Spicejet\\ScreenShots\\signUppage.png"));
    WebElement result = driver.findElement(By.xpath("//div[contains(text(),'Hi Meena')]"));
    Assert.assertEquals("Hi Meena", result.getText());
}

@DataProvider(name = "getFromExcel")
public Object[][] getFromExcel() throws Exception{
	String sheetName = "Sheet1";
	Object[][] data = dataReader(sheetName);
	return data;
}
}
