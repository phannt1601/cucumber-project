package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Before
	public void InitTest()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrives/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.get("https://getwaave.co/auth/login");
    	this.driver.manage().window().maximize();
	}
	
	@After
	public void Finish()
    {
    	this.driver.quit();
    }
	
	@Given("^The user logged in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	    public void the_user_logged_in_with_username_something_and_password_something(String username, String password) 
	{
		LoginPage login = new LoginPage(driver);
    	login.InputUsername(username);
    	login.InputPassword(password);
    	login.doSubmit(); 
	}
	
	@Given("^The dashboard page already showed$")
    public void the_dashboard_page_already_showed() 
	{
        this.driver.get("https://getwaave.co/cms");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^The user open cashback list$")
    public void the_user_open_cashback_list() 
    {
    	driver.findElement(By.xpath("//a[@href='https://getwaave.co/cms/cashbacks']")).click();
    }

    @Then("^The list cashback will showed$")
    public void the_list_cashback_will_showed() 
    {
        
    }

}
