package techstats.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public static void applyExplicitWait(WebDriver driver, By elem, By invisElem)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(invisElem)));

	}
	
	
	
}
