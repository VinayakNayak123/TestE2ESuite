package cucumber.stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import techstats.CartApp.CartHomePage;
import techstats.LoginPage.CartLoginPage;
import techstats.base.TechstatsBase;

public class StepDefinitionImpl extends TechstatsBase {
	
	WebDriver driver;
	CartLoginPage cartPage;
	CartHomePage hm;
	

	@Given("I landed on Ecomm Page")
	public void I_landedOnEcommPage()
	{
		System.out.println("**********EXEC BEFORE SCENARIOS");
	}
	
	@Given("^I have correct (.+) and (.+)$")
	public void login_With_Username_And_Password(String userName,String passWD)
	{
		driver  = openApplication();
		System.out.println(userName +"  *******   "+passWD );
		cartPage = new CartLoginPage(driver);
		cartPage.enterUserNameAndPassword(userName, passWD);
	}

	@And("I have logged in")
	public void I_haveLoggedIn()
	{
		System.out.println("And I have logged in");
	}
	
	@When("^I add Item (.+) in my basket$")
	public void addItemToBasket(String productName) throws InterruptedException
	{
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
		
	}
	
	@Then("Finally message {string} should be displayed")
	public void displayMessageAfterOrder(String message)
	{
		String productName = "ZARA COAT 3";
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
	}
	
	@And("I should see it")
	public void I_should_seeit()
	{
		System.out.println("And I should see it");
	}
	
	
	
	@Given(": I am logged into POS")
	public void i_am_logged_into_pos() {
	   System.out.println("logged in to POS");
	}
	
	@Given(": present on Home Page")
	public void present_on_home_page() {
		System.out.println("home page"); 
	}
	
	@When(": User adds item")
	public void user_adds_item() {
		System.out.println("add Items");
	}
	
	@Then(": I pay by Cash")
	public void i_pay_by_cash() {
		System.out.println("pay by cash");
	}
	
	
	
	
}
