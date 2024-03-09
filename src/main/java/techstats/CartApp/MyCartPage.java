package techstats.CartApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {

	WebDriver driver;
	public MyCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement checkOutBtn;
	
	public void checkOutProcess()
	{
		checkOutBtn.click();
	}
}
