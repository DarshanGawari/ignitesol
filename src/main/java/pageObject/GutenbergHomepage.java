package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GutenbergHomepage {
	
public WebDriver driver;
	

	By Searchandbrowse = By.xpath("(//a[contains(@href,'ebooks')])[1]");
	//By Searchandbrowse = By.partialLinkText("Search and Browse");
	By Frequentlydownload = By.xpath("(//a[contains(@href,'browse/scores/top')])[1]");
	
	
	
	public GutenbergHomepage(WebDriver driver) 
	{			
		this.driver=driver;
	}
	
	
	public WebElement Searchandbrowse()   // object of Search & Browse option  
	{
		return driver.findElement(Searchandbrowse);
	}
	
	public FrequentlyDownloaded Frequentlydownload() // object of Frequently Download option
	{
		driver.findElement(Frequentlydownload).click();				
		FrequentlyDownloaded Fd = new FrequentlyDownloaded(driver); 
		return Fd;
	}
	

}
