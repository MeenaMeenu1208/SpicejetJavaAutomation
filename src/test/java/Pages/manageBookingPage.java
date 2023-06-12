package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class manageBookingPage extends baseClass {
	
	@FindBy(xpath = "//div[contains(text(),'manage booking')]")
	WebElement manageBookingBtn;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div/div[3]")
	WebElement addItineraryBtn;
	@FindBy(xpath = "//input[contains(@class,'css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy')]")
	WebElement PNRorTicketNo;
	@FindBy(xpath = "//input[contains(@class,'css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy')]")
	WebElement emailOrLastname;
	@FindBy(xpath = "//div[contains(@class,'css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu')]")
	WebElement searchBookingBtn;
	
	
	
	public manageBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void manageBooking(String PNRorTicketNo,String emailOrLastname ) throws InterruptedException {
		clickElement(manageBookingBtn);
		clickElement(addItineraryBtn);
		Thread.sleep(2000);
		typeText(this.PNRorTicketNo, PNRorTicketNo);
		Thread.sleep(2000);
		typeText(this.emailOrLastname, emailOrLastname);
		Thread.sleep(2000);
		clickElement(searchBookingBtn);
	
}

}
