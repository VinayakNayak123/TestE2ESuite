package interview.Locators;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LocatorsPractTest {
	
	Properties prop;
	
	@Test
	public void Locatortesting() throws IOException, InterruptedException
	{	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumWebdriver/chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//xpath. just another way of finding xpath in complex applications
		driver.findElement(By.xpath("//form[@class='form']//input[@type='text']")).sendKeys("abcd");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
