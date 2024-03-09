package techstats.CartApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techstats.utility.WaitHelper;


public class CartHomePage {
	WebDriver driver;
	public CartHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> productListElem;
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartIcon;
	
	By textElement = By.cssSelector("b");
	By addToCartButton = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	By ngAnimating = By.cssSelector(".ng-animating");
	
	
	
	public void addItemsToBasketCart(String productName)
	{
		for(WebElement elem : productListElem)
		{
			if (elem.findElement(textElement).getText().equalsIgnoreCase(productName)) {
				elem.findElement(addToCartButton).click();
			}
		}
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public void waitForLoader(WebDriver driver)
	{
		WaitHelper.applyExplicitWait(driver, toastContainer, ngAnimating);
	}
}
