package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pastonletters {
	
public WebDriver driver;
	
	By WebLink = By.linkText("www.gutenberg.org");
	
	public Pastonletters(WebDriver driver) 
	{			
		this.driver=driver;
	}
	
	public GutenbergHomepage WebLink() 
	{
		driver.findElement(WebLink).click();		
		GutenbergHomepage Gh = new GutenbergHomepage(driver);
		return Gh;
	}

}
