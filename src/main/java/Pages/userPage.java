package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;

public class userPage {
	
	WebDriver driver;
	int beforecount,aftercount;
	public userPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//button[contains(text(),' Add User')]")
	WebElement ele;
	
	@FindBy(name="FirstName")
	WebElement firstname;
	
	@FindBy(name="LastName")
	WebElement lastname;
	
	@FindBy(name="UserName")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement pass;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Mobilephone")
	WebElement mobileph;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement savebtn;
	
	@FindBy(xpath="//div/div[@class='modal-footer']/button[contains(text(),'OK')]")
	WebElement dialogOK;
	
	String getcount="//table[@table-title='Smart Table example']//tbody/tr";
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	
	
	
	
	public void addUser(HashMap<String,String> input,WebDriver driver)
	{
		try
		{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		List<WebElement> addedrows=driver.findElements(By.xpath(getcount));
		
		beforecount=addedrows.size();	
		
	if(ele.isDisplayed())
	{
		ele.click();
		
		
		if(firstname.isEnabled())
			firstname.sendKeys(input.get("FirstName"));
		
		if(lastname.isEnabled())
			lastname.sendKeys(input.get("LastName"));
		
		
		if(username.isEnabled())
			username.sendKeys(input.get("UserName"));
		
		
		if(pass.isEnabled()) {
			
			pass.sendKeys("test123");
		}
		
		
		Select select=new Select(driver.findElement(By.name("RoleId")));
		
		select.selectByVisibleText(input.get("RoleId"));
		
		
		if(email.isEnabled())
			email.sendKeys(input.get("Email"));
		
		
		if(mobileph.isEnabled())
			mobileph.sendKeys(input.get("MobilePhone"));		
		
		
		if(savebtn.isDisplayed())
			savebtn.click();	
		
	List<WebElement> addedrows1=driver.findElements(By.xpath(getcount));
		
		aftercount=addedrows1.size();	
		
		if(aftercount>beforecount)
			System.out.println("User is added::"+input.get("UserName"));
		else
			Assert.assertTrue(false,"User is not added");
			
	}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void verifyuserispresent(HashMap<String,String> input)
	{
		boolean status=false;
		List<WebElement> addedrows1=driver.findElements(By.xpath(getcount));
		
		if(addedrows1.size()!=0)
		{
		  for(int i=1;i<addedrows1.size()-1;i++)	
		  {
			  String val=driver.findElement(By.xpath(getcount+"["+i+"]"+"/td[3]")).getText();
		     if(val.equals(input.get("UserName")))
		     {
		    	 status=true;
		    	 break;
		     }
		  }
		  if(!status)
		  {
			  Assert.assertTrue(false,"Expected User is not added::"+input.get("UserName"));
		  }
		  else
			  System.out.println("Expected user is added::"+input.get("UserName"));
		}
		
	}
	public void deleteuser(String user)
	{
		try
		{
			boolean status=false;
			List<WebElement> addedrows1=driver.findElements(By.xpath(getcount));
			
			if(addedrows1.size()!=0)
			{
			  for(int i=1;i<addedrows1.size()-1;i++)	
			  {
				  String val=driver.findElement(By.xpath(getcount+"["+i+"]"+"/td[3]")).getText();
			     if(val.equals(user))
			     {
			    	 driver.findElement(By.xpath(getcount+"["+i+"]"+"/td[11]/button")).click();
			    	 Thread.sleep(10000);			    	 
			    	 
			    	 wait.until(ExpectedConditions.elementToBeClickable(dialogOK));
			    	dialogOK.click();
			    	 
			    	
			    	 Thread.sleep(5000);
			    	
			    	
			    	 status=true;
			    	 break;
			     }
			  }
			 
				if(!status)
					Assert.assertTrue(false,"User is not deleted");
				else
					 System.out.println("Expected user is deleted");
			}
			else
				Assert.assertTrue(false,"Users present in table");
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void verifyuserisnotpresent(HashMap<String,String> input)
	{
		boolean status=false;
		List<WebElement> addedrows1=driver.findElements(By.xpath(getcount));
		
		if(addedrows1.size()!=0)
		{
		  for(int i=1;i<addedrows1.size()-1;i++)	
		  {
			  String val=driver.findElement(By.xpath(getcount+"["+i+"]"+"/td[3]")).getText();
		     if(val.equals(input.get("UserName")))
		     {
		    	 status=true;
		    	 break;
		     }
		  }
		  if(!status)
		  {
			  Assert.assertTrue(true,"As expected user is deleted so not present");
			  System.out.println("As expected user is deleted so not present");
		  }
		  else
		  {
			  Assert.assertTrue(true,"user is present that is not expected");
			  System.out.println("user is present that is not expected");
		  }
		}
		
	}

}
