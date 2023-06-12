package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class flightStatusPage extends baseClass {
	@FindBy(xpath = "//div[contains(text(),'flight status')]")
	WebElement flightStatusButton;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep')]")
	WebElement dateDrop;
	
	@FindBy(xpath = "//div[contains(text(),'Tomorrow')]")
	WebElement daySelect;
	@FindBy(xpath = "//input[contains(@class,'css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu')]")
	WebElement fromTextBox;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div[1]/div[2]/input")
	WebElement ToTextBox;
	@FindBy(xpath = "//input[contains(@class,'css-1cwyjr8 r-homxoj r-1i10wst r-1eimq0t r-mk0yit r-xfkzu9 r-lnhwgy')]")
	WebElement flightNo;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu')]")
	WebElement searchFlightButton;
	
	
	
	public flightStatusPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void flightStatus(String fromTextBox,String ToTextBox, String flightNo ) throws InterruptedException {
		clickElement(flightStatusButton);
		Thread.sleep(2000);
		clickElement(dateDrop);
		Thread.sleep(2000);
		clickElement(daySelect);
		Thread.sleep(2000);
		this.fromTextBox.click();
		typeText(this.fromTextBox, fromTextBox);
		Thread.sleep(2000);
		this.ToTextBox.click();
		typeText(this.ToTextBox, ToTextBox);
		
		typeText(this.flightNo, flightNo);	
		clickElement(searchFlightButton);
	
}

}
