package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.baseClass;

public class checkInPage extends baseClass {

	@FindBy(xpath = "//div[contains(text(),'check-in')]")
	WebElement checkinButton;
	@FindBy(xpath = "//input[contains(@class,'css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy')]")
	WebElement ticketorPNRNum;
	@FindBy(xpath = "//input[contains(@placeholder,'john.doe@spicejet.com')]")
	WebElement emailorLastName;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu')]")
	WebElement searchBoookingButton;
	
	
	
	public checkInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkIn(String ticketorPNRNum,String emailorLastName ) throws InterruptedException {
		clickElement(checkinButton);
		typeText(this.ticketorPNRNum, ticketorPNRNum);
		typeText(this.emailorLastName, emailorLastName);
		clickElement(searchBoookingButton);
		Thread.sleep(10000);
		//String alertText = driver.switchTo().alert().getText();
		//System.out.println(alertText);
		//driver.switchTo().alert().dismiss();
		/*WebDriverWait w = new WebDriverWait(driver, 5);
	      //alertIsPresent() condition applied
	      if(w.until(ExpectedConditions.alertIsPresent())==null)
	      System.out.println("Alert not exists");
	      else
	      System.out.println("Alert exists");*/
}
}
