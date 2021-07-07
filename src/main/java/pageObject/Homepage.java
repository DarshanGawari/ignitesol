package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	
	public WebDriver driver;
	
	By History =By.xpath("//span[contains(text(),'HISTORY')]");
	
public Homepage(WebDriver driver) {  //Constructor
		
		this.driver=driver;
	}

	public Historysection btnHistory() //This is object of history Button 
	{
		driver.findElement(History).click();
		Historysection hs = new Historysection(driver);
		 return hs;
	}
	

}
