package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.baseClass;

public class loginPage extends baseClass {
	

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginButton;
	@FindBy(xpath = "//input[contains(@type,'number')]")
	WebElement mbNum;
	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement passWrd;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73')]")
	WebElement loginSbmitButton;

	
	public loginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logIn(String mbNum,String passWrd ) throws InterruptedException {
		clickElement(loginButton);
		windowHandles();
		typeText(this.mbNum, mbNum);
		typeText(this.passWrd, passWrd);
		clickElement(loginSbmitButton);
	
}
}