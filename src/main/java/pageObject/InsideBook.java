package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsideBook {
	
	public WebDriver driver;
	
	By volume2 = By.linkText("Volume II");
	
	public InsideBook(WebDriver driver) //Constructor
	{			
		this.driver=driver;
	}
	
	public Pastonletters volume2() // object of volume II 
	{
		driver.findElement(volume2).click();
		
		Pastonletters Pl = new Pastonletters(driver);
		 return Pl;
		
	}

}
