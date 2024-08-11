package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class userPage {
	
	static WebDriver driver;
	
	
	public WebDriver launchApplication() throws FileNotFoundException, IOException
	{
		driver=new EdgeDriver();
		
		driver.get(getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getProperty(String key) throws FileNotFoundException, IOException
	{
				
		Properties prop = new Properties();
		String path=System.getProperty("user.dir");
		prop.load(new FileInputStream(path+"\\src\\test\\resources\\config.properties"));
		return prop.getProperty(key);

	}

}
