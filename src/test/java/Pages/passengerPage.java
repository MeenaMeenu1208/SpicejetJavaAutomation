package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class passengerPage extends baseClass {
	
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[3]/div[1]/div[2]/div/div[2]")
	WebElement titleDrop;
	@FindBy(xpath = "//div [contains(text(),'Miss')]")
	WebElement ms;
	@FindBy(xpath = "//input [contains(@class,'css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy')]")
	WebElement fname;
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[3]/div[3]/div/div/div[2]/input")
	WebElement lname;
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[3]/div[4]/div/div[2]/input")
	WebElement MbNumber;
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[4]/div[1]/div/div/div[2]/input")
	WebElement email;
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[4]/div[2]/div[2]/div/div[2]")
	WebElement countryDrop;
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[4]/div[2]/div[2]/div[2]/div[1]/div/div[2]/input")
	WebElement searchBox;
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div")
	WebElement IndiaSelect;
	
	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[4]/div[3]/div/div/div[2]/input")
	WebElement TownCity;

	@FindBy(xpath = "//*[@id=\"primary-contact-details\"]/div[5]/div[2]/div/div[2]")
	WebElement checkBox;
	@FindBy(xpath = "//*[@id=\"pax-item-MCFBRFQ-\"]/div[2]/div/div/div[1]/div/div/div/div[2]")
	WebElement checkBox2;
	@FindBy(xpath = "//*[@id=\"travellers-view\"]/div[2]/div/div/div[2]")
	WebElement ContinueButton2;
	
	
	public passengerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void passenger(String fname,String lname, String MbNumber, String email, String TownCity ) throws InterruptedException {
		Thread.sleep(2000);
		clickElement(titleDrop);
		Thread.sleep(2000);
		clickElement(ms);
		this.TownCity.sendKeys("Coimbatore");
		Thread.sleep(2000);
		clickElement(checkBox);
		Thread.sleep(2000);
		clickElement(checkBox2);
		Thread.sleep(2000);
		clickElement(ContinueButton2);
		Thread.sleep(2000);
	
}
	
	
	
	

}
