package base;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.utils;

public class baseClass extends utils{
	
	//prerequisite
			@BeforeMethod
			public void start() throws Exception {
				
				browserLaunch(getpropvalue("browser"));
				launchUrl(getpropvalue("url"));
				driver.manage().window().maximize();
				driver.findElement(By.name("q")).sendKeys("https://www.spicejet.com/"+"\n");
				driver.findElement(By.xpath("//h3")).click();
				Thread.sleep(2000);
			}
			
		
				
			@AfterMethod
			public void close() {
			driver.quit();
			}

}
