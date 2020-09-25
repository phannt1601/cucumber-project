package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	By UsernameEl = By.cssSelector("input[name = 'username']");
	By PasswordEl = By.cssSelector("input[name='password']");
	By SubmitEl = By.cssSelector("button[type='submit']");
	
	public void InputUsername (String username)
	{
		WebElement txtUsername = this.driver.findElement(UsernameEl);
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	
	public void InputPassword (String password)
	{
		WebElement txtPassword = this.driver.findElement(PasswordEl);
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void doSubmit ()
	{
		this.driver.findElement(SubmitEl).click();
	}

}
