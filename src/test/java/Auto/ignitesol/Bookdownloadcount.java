package Auto.ignitesol;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObject.FrequentlyDownloaded;
import pageObject.GutenbergHomepage;
import pageObject.Historysection;
import pageObject.Homepage;
import pageObject.InsideBook;
import pageObject.Pastonletters;
import resource.Base;

public class Bookdownloadcount extends Base {
	
	
	public WebDriver driver;
	
	
	@BeforeMethod
	
	public void initialized() throws IOException 
	{
		driver = initializeDriver();  // This method will initialized browser in which we want to run test case  
	}
	
	@Test
	
	public void Bookdownloadcount() throws InterruptedException 
	{
		driver.get(url); //Will invoke url which is parameterized in Data.properties file
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit wait apply to wait to load elements
		
		driver.manage().window().maximize(); //This will maximized browser window 
		
		Homepage hp = new Homepage(driver);
		
		Historysection hs = hp.btnHistory(); //This will click on History button and navigate to History section
		
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
		InsideBook Ib = hs.bookname();  // This open required book
		
		Pastonletters Pl =Ib.volume2(); // This will redirected to volume II link
		
		GutenbergHomepage Gh = Pl.WebLink();   //This will open Gutenberg home page
		
		String expectedurl = "https://www.gutenberg.org/";
		
		String actualurl = driver.getCurrentUrl();   //Get url of current open page
		
		Assert.assertEquals(expectedurl, actualurl); // Verify page redirected to required link 
		
		WebElement Searchandbrowse = Gh.Searchandbrowse(); 
		
		
		Actions a = new Actions(driver);
		
		a.moveToElement(Searchandbrowse).build().perform(); // Mousehover action to Search & Browse option in menu bar
		
		FrequentlyDownloaded Fd = Gh.Frequentlydownload(); // Click on Frequently Download option inside Search & Browse option
		
		List<WebElement> Teablehead= Fd.tableHeading(); // List of table headers
						
		List<String>count = Teablehead.stream().filter(s->s.getText().contains("last 7 days")).map(s->getcount(s)).collect(Collectors.toList());
		//This will give book count for last 7 days
		
		
		count.forEach(s->System.out.println(s)); //This will print count of how many times books are downloaded
		
		
					
	}
	
	private static String getcount(WebElement s) //This will traverse next column where value last 7 days is matches
	{
		
		String Value =s.findElement(By.xpath("following-sibling::td[1]")).getText();			
		return Value;
	}

	
	@AfterMethod
	public void teardown() 
	{		
		driver.close();  //This will close the focused window
	}

}
