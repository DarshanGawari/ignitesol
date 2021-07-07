package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Historysection {
	
	public WebDriver driver;
	
	By SearchBookinput = By.id("outlined-full-width");
	By BtnSearch = By.xpath("//button");
	By booktitle = By.xpath("//div[@class='computer only column']/div/a/h5");
	By bookname = By.xpath("(//a[contains(@href,'43348')])[1]");
	
	
	
	
	public Historysection(WebDriver driver) 
	{			
		this.driver=driver;
	}
	
	public WebElement SearchBookinput() //Object of Search InputBox
	{
		return driver.findElement(SearchBookinput);
	}
	
	public WebElement BtnSearch() //Object of Search button
	{
		return driver.findElement(BtnSearch);
	}
	
	public List<WebElement> booktitle() //Object of book list
	{
		return driver.findElements(booktitle);
	}
	
	public InsideBook bookname() //Object of book title
	{
		driver.findElement(bookname).click();
		InsideBook Ib = new InsideBook(driver);
		return Ib;
		
	}

}
