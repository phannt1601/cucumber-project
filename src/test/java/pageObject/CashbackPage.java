package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CashbackPage {
	
	WebDriver driver;
	List<WebElement> listColumns;
	
	public CashbackPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	By VenueNameEl = By.cssSelector("input[name = 'venue']");
	By UsernameEl = By.cssSelector("input[name = 'username']");
	By SearchEl = By.cssSelector("input[type = 'submit'][value='Search']");
	By FromDateEl = By.cssSelector("input[name='from_date']");
	By ToDateEl = By.cssSelector("input[name='to_date']");
	
	public void InputUsername (String username)
	{
		WebElement txtUsername = this.driver.findElement(UsernameEl);
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	
	public void InputVenueName (String venue)
	{
		WebElement txtVenueName = this.driver.findElement(VenueNameEl);
		txtVenueName.clear();
		txtVenueName.sendKeys(venue);
	}
	
	public void doSearch ()
	{
		this.driver.findElement(SearchEl).click();
	}
	
	public void SelectIssue(String issue)
	{
		Select selectByVisibleText = new Select (driver.findElement(By.id("cashback-status")));
		selectByVisibleText.selectByVisibleText(issue);
	}
	
	public void SelectFromDate(String fromdate) throws Exception 
	{
		WebElement openDatepicker = this.driver.findElement(FromDateEl);
		openDatepicker.click();
		Thread.sleep(5000);
		
		//listColumns = openDatepicker.findElements(By.tagName("td"));
		listColumns = openDatepicker.findElements(By.xpath("//table[@class='table-condensed']//td"));
		
		for (WebElement cell: listColumns)
		{
			String date = cell.getText();
			if (date.equals(fromdate))
			{			   
				cell.click();
			    break;
			}
		}
		Thread.sleep(5000);
	}

	public void SelectToDate(String todate) throws Exception 
	{
		WebElement openDatepicker = this.driver.findElement(ToDateEl);
		openDatepicker.click();
		Thread.sleep(5000);
	
		listColumns = openDatepicker.findElements(By.xpath("//table[@class='table-condensed']//td"));
		
		for (WebElement cell: listColumns)
		{
			String date = cell.getText();
			if (date.equals(todate))
			{			   
				cell.click();
			    break;
			}
		}
		Thread.sleep(5000);
	}
	
	public void SelectFromDateOfPreviousMonth(String fromdate) throws Exception
	{
		WebElement openDatepicker = this.driver.findElement(FromDateEl);
		openDatepicker.click();
		Thread.sleep(5000);
		
		WebElement previousLink = openDatepicker.findElement(By.xpath("//th[@class='prev available']"));
		//WebElement nextLink = openDatepicker.findElement(By.xpath("//th[@class='next available']"));
		
		previousLink.click();
		//nextLink.click();
		Thread.sleep(5000);
		
		listColumns = openDatepicker.findElements(By.xpath("//table[@class='table-condensed']//td"));
		
		for (WebElement cell: listColumns)
		{
			String date = cell.getText();
			if (date.equals(fromdate))
			{			   
				cell.click();
			    break;
			}
		}
		Thread.sleep(5000);
	}
	
}
