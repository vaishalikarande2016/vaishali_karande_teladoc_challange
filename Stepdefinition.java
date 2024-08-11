package Stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Pages.userPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdefinition {
	
	userPage obj=new userPage();
	WebDriver driver;
	int beforecount,aftercount;
	@Before
	public void setup() throws FileNotFoundException, IOException
	{
		driver=obj.launchApplication();
	}
	
	@Given("Add user")
	public void add_user() {
		
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			List<WebElement> addedrows=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody/tr"));
			
			beforecount=addedrows.size();	
			
		WebElement ele=driver.findElement(By.xpath("//button[contains(text(),' Add User')]"));
		if(ele.isDisplayed())
		{
			ele.click();
			
			WebElement firstname=driver.findElement(By.name("FirstName"));
			if(firstname.isEnabled())
				firstname.sendKeys("test23");
			
			WebElement lastname=driver.findElement(By.name("LastName"));
			if(lastname.isEnabled())
				lastname.sendKeys("test");
			
			WebElement username=driver.findElement(By.name("UserName"));
			if(username.isEnabled())
				username.sendKeys("test123");
			
			WebElement pass=driver.findElement(By.name("Password"));
			if(pass.isEnabled())
				pass.sendKeys("test123");
			
			
			
			Select select=new Select(driver.findElement(By.name("RoleId")));
			
			select.selectByVisibleText("Customer");
			
			WebElement email=driver.findElement(By.name("Email"));
			if(email.isEnabled())
				email.sendKeys("test123@domain.com");
			
			WebElement mobileph=driver.findElement(By.name("Mobilephone"));
			if(mobileph.isEnabled())
				mobileph.sendKeys("1234567891");
			
			
			WebElement savebtn=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
			if(savebtn.isDisplayed())
				savebtn.click();						
			
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Then("Verify user is added")
	public void verify_user_is_added() {
	   
		try
		{
		List<WebElement> addedrows=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody/tr"));
		
		 aftercount=addedrows.size();
			
			if(beforecount==aftercount)
				Assert.assertTrue(false, "User not added");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Given("Delete user")
	public void delete_user() {
	   
	}

	@Then("Verify user is deleted")
	public void verify_user_is_deleted() {
	   
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		
	}


}
