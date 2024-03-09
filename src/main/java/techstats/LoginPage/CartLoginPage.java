package techstats.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techstats.CartApp.CartHomePage;
import techstats.base.TechstatsBase;

public class CartLoginPage  {
WebDriver driver;

	public CartLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userId;
	
	@FindBy(id="userPassword")
	WebElement userPwd;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	public CartHomePage enterUserNameAndPassword(String userName,String password)
	{
		userId.sendKeys(userName);
		userPwd.sendKeys(password);
		loginBtn.click();
		return new CartHomePage(driver);
	}
	
	
}
