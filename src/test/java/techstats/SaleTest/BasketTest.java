package techstats.SaleTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import techstats.CartApp.CartHomePage;
import techstats.LoginPage.CartLoginPage;
import techstats.base.TechstatsBase;

public class BasketTest extends TechstatsBase {

	WebDriver driver;
	CartLoginPage cartPage;
	CartHomePage hm;
	
	@BeforeMethod
	public void setUp()
	{
		driver  = openApplication();
	}
	
	@Test
	public void addToBasket()
	{
		cartPage = new CartLoginPage(driver);
		cartPage.enterUserNameAndPassword("user@usertest.com", "Usertest@123");
		hm = new CartHomePage(driver);
		hm.addItemsToBasketCart("ADIDAS ORIGINAL");
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hm.clickOnCartIcon();
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

	
}
