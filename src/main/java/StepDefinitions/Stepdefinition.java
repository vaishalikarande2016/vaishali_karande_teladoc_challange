package StepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pages.BaseTest;
import Pages.userPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdefinition extends BaseTest{
	
	
	userPage obj;
	WebDriver driver;
	int beforecount,aftercount;
	HashMap<String,String> input;//=new HashMap<String,String>();
	
	
	@Before
	public void setup() throws FileNotFoundException, IOException
	{
		driver=launchApplication();
		obj=new userPage(driver);
		
	}
	
	@Given("Add user")
	public void add_user(DataTable data) {
		
		input=new HashMap<String, String>(data.asMap(String.class,String.class));
		try
		{	
			
			
			obj.addUser(input,driver);

		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Then("validate the user has been added to the table")
	public void verify_user_is_added(DataTable data) {
	   
		try
		{
			input=new HashMap<String,String>(data.asMap(String.class,String.class));
			obj.verifyuserispresent(input);

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Given("Delete the user {string} from the table")
	public void delete_the_user_from_the_table(String user)
    {	
		try
		{
			obj.deleteuser(user);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}


	@Then("validate the user has been deleted")
	public void verify_user_is_deleted(DataTable data) {	   
		try
		{
			input=new HashMap<String,String>(data.asMap(String.class,String.class));
		obj.verifyuserisnotpresent(input);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		
	}


}
