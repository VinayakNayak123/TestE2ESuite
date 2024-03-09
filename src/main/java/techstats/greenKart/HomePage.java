package techstats.greenKart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techstats.base.TechstatsBase;

public class HomePage extends TechstatsBase {

	@FindBy(className="search-keyword")
	WebElement searchTextBox;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterTextinSearchBox(String textToEnter)
	{
		searchTextBox.sendKeys(textToEnter);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
