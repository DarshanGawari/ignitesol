package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrequentlyDownloaded {
	
	By tableHeading = By.xpath("//table/tbody/tr/th");
	
	
	public WebDriver driver;
	
	public FrequentlyDownloaded(WebDriver driver) //constructor
	{			
		this.driver=driver;
	}
	
	public List<WebElement> tableHeading() //Table header objects
	{
		return driver.findElements(tableHeading);
	}
	


}
