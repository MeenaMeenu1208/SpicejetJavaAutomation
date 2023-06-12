package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class addOnsPage extends baseClass {

	@FindBy(xpath = "//*[@id=\"at_addon_close_icon\"]/img")
	WebElement addonsCloseButton;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[5]/div/div/div[2]/div/div/div[4]")
	WebElement continueButton3;
	@FindBy(id = "skipfrompopup")
	WebElement skipCompfort;
	
	public addOnsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addOns() throws InterruptedException {
		Thread.sleep(3000);
		clickElement(continueButton3);
		Thread.sleep(1000);
		clickElement(skipCompfort);
		Thread.sleep(3000);
}
}
