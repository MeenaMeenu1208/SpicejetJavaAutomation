package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.baseClass;

public class oneWayTrip extends baseClass {
	
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/svg/g/circle[1]")
	WebElement oneWayButton;
	@FindBy(xpath = "//input[contains(@class,'css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu')]")
	WebElement fromTextBox;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div[1]/div[2]/input")
	WebElement toTextBox;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]')]")
	WebElement fromDate;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[2]/div/div")
	WebElement dateSelect;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]")
	WebElement PassengerSelect;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid')]")
	WebElement plusButton;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[1]")
	WebElement MinusButton;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div[1]/div[2]")
	WebElement currencySelect;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div[2]/div[2]/div/div[1]")
	WebElement INR;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73')]")
	WebElement searchFlightButton;
	@FindBy(xpath = "//div [contains(text(),'Previous Day')]')]")
	WebElement previousDay;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[5]/div/div/div[3]/div[2]")
	WebElement ContinueButton;
	
	
	public oneWayTrip() {
		PageFactory.initElements(driver, this);
	}

	public void oneWay(String fromTextBox,String toTextBox) throws InterruptedException {
		Thread.sleep(2000);
		clickElement(oneWayButton);
		
		Thread.sleep(2000);
		this.fromTextBox.click();
		typeText(this.fromTextBox, fromTextBox);
		Thread.sleep(2000);
		this.toTextBox.click();
		typeText(this.toTextBox, toTextBox);
		Thread.sleep(2000);
		clickElement(fromDate);
		Thread.sleep(2000);
		clickElement(dateSelect);
		Thread.sleep(2000);
		clickElement(PassengerSelect);
		Thread.sleep(2000);
		clickElement(plusButton);
		Thread.sleep(2000);
		clickElement(MinusButton);
		Thread.sleep(2000);
		clickElement(currencySelect);
		Thread.sleep(2000);
		clickElement(INR);
		Thread.sleep(2000);
		clickElement(searchFlightButton);
		Thread.sleep(2000);
		clickElement(ContinueButton);
		Thread.sleep(2000);
		/*clickElement(titleDrop);
		Thread.sleep(2000);
		clickElement(ms);
		this.TownCity.sendKeys("Coimbatore");
		Thread.sleep(2000);
		clickElement(checkBox);
		Thread.sleep(2000);
		clickElement(checkBox2);
		Thread.sleep(2000);
		clickElement(ContinueButton2);
		Thread.sleep(2000);/*
		/*if(addonsCloseButton.isEnabled()) {
			addonsCloseButton.click();
		}*/
		/*Thread.sleep(2000);
		clickElement(continueButton3);
		Thread.sleep(2000);
		if(skipCompfort.isEnabled()) {
			skipCompfort.click();
		}*/
		
}
}
