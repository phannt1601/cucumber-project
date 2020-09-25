package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TopupCodesPage {
	
	WebDriver driver;
	List<WebElement> listColumns;
	
	public TopupCodesPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	By CodeEl = By.cssSelector("input[name = 'code']");
	By ValueEl = By.cssSelector("input[name = 'value']");
	By SaveEl = By.cssSelector("button[class='form-control btn btn-flat btn-info']");
	By FromDateEl = By.cssSelector("input[name='date_from']");
	By ToDateEl = By.cssSelector("input[name='date_to']");
	
	public void SelectCurrency(String currency)
	{
		Select selectByVisibleText = new Select (driver.findElement(By.name("currency_code")));
		selectByVisibleText.selectByVisibleText(currency);
	}
	
	public void SelectType(String type)
	{
		Select selectByVisibleText = new Select (driver.findElement(By.name("type")));
		selectByVisibleText.selectByVisibleText(type);
	}
	
	public void InputCode (String code)
	{
		WebElement txtCode = this.driver.findElement(CodeEl);
		txtCode.clear();
		txtCode.sendKeys(code);
	}
	
	public void InputValue (String value)
	{
		WebElement txtValue = this.driver.findElement(ValueEl);
		txtValue.clear();
		txtValue.sendKeys(value);
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
	
	public void doSave ()
	{
		this.driver.findElement(SaveEl).click();
	}

}
