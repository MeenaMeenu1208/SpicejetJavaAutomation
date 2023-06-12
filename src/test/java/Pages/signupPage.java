package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.baseClass;

public class signupPage extends baseClass{

	@FindBy(xpath = "//div [contains(text(),'Signup')]")
	WebElement signUpButton;
	@FindBy(xpath = "//select [contains(@class,'form-control form-select ')]")
	WebElement titleDropdown;
	@FindBy(id = "first_name")
	WebElement firstName;
	@FindBy(id = "last_name")
	WebElement lastName;
	@FindBy(xpath = "//select [contains(@tabindex,'0')]")
	WebElement countrydrpDown;
	@FindBy(xpath = "//img [contains(@class,'d-inline-block datepicker')]")
	WebElement dobDate;
	@FindBy(xpath = "//input[contains(@class,' form-control')]")
	WebElement mobileNumber;
	@FindBy(id = "email_id")
	WebElement emailID;
	@FindBy(id = "new-password")
	WebElement newPassword;
	@FindBy(id = "c-password")
	WebElement cPassword;
	@FindBy(id = "defaultCheck1")
	WebElement checkBox;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitButton;
	
	
	public signupPage() {
		PageFactory.initElements(driver, this);
	}

	public void SignUp(String firstName,String lastName,String dobDate,String mobileNumber,String emailID,String newPassword, String cPassword ) throws InterruptedException {
		clickElement(signUpButton);
		windowHandles();
		Select select = new Select(titleDropdown);
		select.selectByVisibleText("Ms");
		Thread.sleep(2000);
		typeText(this.firstName, firstName);
		typeText(this.lastName, lastName);
	    Select select1 = new Select(countrydrpDown);
		select1.selectByVisibleText("India");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		//this.dobDate.click();
		driver.findElement(By.xpath("//img [contains(@class,'d-inline-block datepicker')]")).click();
		WebElement month = driver.findElement(By.xpath("//select[contains(@class,'react-datepicker__month-select')]"));
		Select select2 = new Select(month);
		select2.selectByVisibleText("August");
	
		WebElement year = driver.findElement(By.xpath("//select[contains(@class,'react-datepicker__year-select')]"));
		Select select3 = new Select(year);
		select3.selectByVisibleText("1999");
		driver.findElement(By.xpath("//div[contains(text(),'12')]")).click();		
		Thread.sleep(4000);
		
		
		//typeText(this.emailID, emailID); 
		typeText(this.mobileNumber, mobileNumber);
		Thread.sleep(4000);
		typeText(this.emailID, emailID);
		Thread.sleep(4000);
		typeText(this.newPassword, newPassword);
		Thread.sleep(4000);
		typeText(this.cPassword, cPassword);
		Thread.sleep(4000);
		this.emailID.clear();
		typeText(this.emailID, emailID);
		Thread.sleep(2000);
		boolean b = checkBox.isEnabled();
		if(b==true) {
			System.out.println("check box is enabled");
		}
		clickElement(checkBox);
		Thread.sleep(2000);
		clickElement(submitButton);
	}



	
}
