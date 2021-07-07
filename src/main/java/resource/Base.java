package resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public Properties prop;
	public WebDriver driver;
	public String url;
	public FileInputStream fis;
	
	public WebDriver initializeDriver() throws IOException 
	{
		prop = new Properties();
		
		fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\ignitesol\\src\\main\\java\\resource\\Data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","D:/Darshan/Software testing/Web Browser driver/chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "D:/Darshan/Software testing/Web Browser driver/geckodriver.exe");			
			driver = new FirefoxDriver();

		}
		else if(browserName.equals("IternetExplorer")) 
		{


		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
