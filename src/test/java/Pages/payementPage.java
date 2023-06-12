package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class payementPage extends baseClass {
	@FindBy(xpath = "//div[contains(text(),'Credit/Debit Card')]")
	WebElement paymentType1;
	@FindBy(xpath = "//div[contains(text(),'NetBanking')]")
	WebElement paymentType2;
	@FindBy(xpath = "//div[contains(text(),'UPI')]")
	WebElement paymentType3;
	@FindBy(name = "card_number_iframe_koFYLEezZBiZH9dn")
	WebElement iframename;
	@FindBy(id = "card_number")
	WebElement cardNumber;
	@FindBy(id = "name_on_card")
	WebElement nameonCard;
	@FindBy(id = "card_exp_month")
	WebElement expMonth;
	@FindBy(id = "card_exp_year")
	WebElement expYear;
	
	@FindBy(id = "security_code")
	WebElement secCode;
	@FindBy(id = "//div[contains(text(),'Proceed to pay')]")
	WebElement proceedToPay;
	
	public payementPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void payMent(String cardNumber,String nameonCard,String expMonth, String expYear,String secCode ) throws InterruptedException {
		Thread.sleep(2000);
		this.paymentType3.click();
		this.paymentType2.click();
		this.paymentType1.click();
		Thread.sleep(2000);
		WebElement iframename = driver.findElement(By.xpath("//*[@id=\"payment_form\"]/div[2]/div[1]/iframe"));
		
		//*[@id="payment_form"]/div[3]/div[1]/iframe"
		driver.switchTo().frame(iframename);
		//this.cardNumber.click();
		if(this.cardNumber.isEnabled())
		{
			System.out.println("Textbox is enabled");
		}
		typeText(this.cardNumber, cardNumber);
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		WebElement iframename2 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[3]/div[1]/iframe"));
		driver.switchTo().frame(iframename2);
		
		
		//WebElement iframename2 = driver.findElement(By.xpath("//*[@id=\"payment_form\"]/div[3]/div[1]/iframe"));
		//driver.switchTo().frame(iframename2);
		if(this.nameonCard.isEnabled())
		{
			System.out.println("nameonCard is enabled");
		}
		typeText(this.nameonCard, nameonCard);
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		WebElement iframename3 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[4]/div[1]/div[1]/iframe"));
		driver.switchTo().frame(iframename3);
		typeText(this.expMonth, expMonth);
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		WebElement iframename4 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[4]/div[1]/div[2]/iframe"));
		driver.switchTo().frame(iframename4);
		typeText(this.expYear, expYear);
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		WebElement iframename5 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/form/div[4]/div[2]/div/iframe"));
		driver.switchTo().frame(iframename5);
		typeText(this.secCode, secCode);
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		clickElement(this.proceedToPay);
	
}

}
