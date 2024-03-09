package techstats.SaleTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import techstats.CartApp.CartHomePage;
import techstats.CartApp.MyCartPage;
import techstats.LoginPage.CartLoginPage;
import techstats.base.TechstatsBase;



public class SaleTransactionTest extends TechstatsBase{
	
	WebDriver driver;
	CartLoginPage cartPage;
	CartHomePage hm;
	
	@BeforeMethod
	public void setUp()
	{
		driver  = openApplication();
	}
	
	
	
	@Test
	public void checkOutProcess() 
	{
		cartPage = new CartLoginPage(driver);
		cartPage.enterUserNameAndPassword("user@usertest.com", "Usertest@123");
		hm = new CartHomePage(driver);
		hm.addItemsToBasketCart("ADIDAS ORIGINAL");
		
		// hm.waitForLoader(driver); //wait is not working so have used sleep method
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hm.clickOnCartIcon();
		MyCartPage cp = new MyCartPage(driver);
		cp.checkOutProcess();
		
		
	}
	
	@Test
	public void standaloneTests() throws InterruptedException
	{
		String productName = "ZARA COAT 3";
		cartPage = new CartLoginPage(driver);
		cartPage.enterUserNameAndPassword("user@usertest.com", "Usertest@123");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
			
			
			WebElement prod =	products.stream().filter(product->
				product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
				prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
				Thread.sleep(9000);
				
				/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
				//ng-animating
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				*/
				driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
				
				List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
				Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
				Assert.assertTrue(match);
				driver.findElement(By.cssSelector(".totalRow button")).click();
				
				Actions a = new Actions(driver);
				a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
				
				driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
				driver.findElement(By.cssSelector(".action__submit")).click();
				
				String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
				Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}

}
