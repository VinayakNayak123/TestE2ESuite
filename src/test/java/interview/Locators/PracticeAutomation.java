package interview.Locators;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeAutomation {
	
	@Test
	public void Automationtesting() throws IOException, InterruptedException
	{	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumWebdriver/chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//radio button
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
		//suggestion example
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		List<WebElement> arrList = driver.findElements(By.className("ui-menu-item"));
		for(WebElement elem : arrList)
		{
			if(elem.getText().equalsIgnoreCase("India"))
			{
				elem.click();
			}
		}
		
		//Drop down
		WebElement dropdownElem = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdownElem);
		select.selectByVisibleText("Option2");
		
		//Checkbox
		driver.findElement(By.id("checkBoxOption2")).click();
		
		//switch window
		driver.findElement(By.id("openwindow")).click();
		String parentWinHandle = driver.getWindowHandle();
		String expectedTitle="QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
		
		Set<String> allWinHandles = driver.getWindowHandles();
		for(String str : allWinHandles)
		{
			if(str.equalsIgnoreCase(expectedTitle))
			{
				driver.switchTo().window(str);
				String actualTitle = driver.getTitle();
				System.out.println(actualTitle+"  ******************");
				Assert.assertEquals(actualTitle, expectedTitle);
			}
		}
		
		driver.switchTo().window(parentWinHandle);
		
		Thread.sleep(5000);
		driver.quit();
	}


}
