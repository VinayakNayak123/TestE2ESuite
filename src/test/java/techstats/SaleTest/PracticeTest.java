package techstats.SaleTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;



public class PracticeTest  {
	
	@Test
	public void LocatorsTest()
	{
		WebDriver driver;
		String url2="https://rahulshettyacademy.com/AutomationPractice/";
		String url="https://rahulshettyacademy.com/locatorspractice/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumWebdriver/chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		
		       //by id
				driver.findElement(By.id("inputUsername")).sendKeys("hello");
				//by Name
				driver.findElement(By.name("inputPassword")).sendKeys("test");
				
				//by class Name
				driver.findElement(By.className("signInBtn")).click();	
				
				//by css selector ->  tagName.className
				String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
				System.out.println(errorMsg);
			
				//click on forget password
				driver.findElement(By.linkText("Forgot your password?")).click();	
				
				
				//enter username xpath -> //tagName[@attribute='value']
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("vinayak");
					
				
				// enter username    xpath -> //tagName[@attribute='value'](index)
				//driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("vinayakTest");
				
				
				//enter password  css -> //tagName[attribute='value']
				driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@test.com");
				
				//cssSelector ->  tagName[attribute='value']:nth-child(index)
				driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
				
				driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("myTest@test.com");
				
				//  xpath -> //parentTagName/childTagName 
				driver.findElement(By.xpath("//form/input[3]")).sendKeys("7764599876");
				
				//css -> .className
				driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
				
				//css -> parentTagName childTagName
				String infoMsg = driver.findElement(By.cssSelector("form p")).getText();
				String updatedText = infoMsg.split("'")[1];
				String passwordText = updatedText.split("'")[0];
				System.out.println(passwordText);
				
				//  xpath->  $x("//div[@class = 'forgot-pwd-btn-conainer']/button[@class='go-to-login-btn']")
				driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[@class='go-to-login-btn']")).click();
				
				//css -> #id
				driver.findElement(By.cssSelector("#inputUsername")).sendKeys("vinayak");
				
				
				// $("input[type*='pass']")
				//css regular expression -> tagName[attribute *= 'value']
				driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(passwordText);
				
				//xpath regular expression -> tagName[contains(@attribute,'value')]
				//$x("//button[contains(@class,'submit')]")
				driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();	
				
				//xpath -> 
				//$x("//button[text() = 'Log Out']")   OR  $x("//*[text() = 'Log Out']")
				driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
				
		
	}
	
	@Test
	public void siblingAndChilDToParentTest()
	{
		
		WebDriver driver;
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumWebdriver/chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		//sibling,  //  $x("//div/button[text()='Practice']/following-sibling::button[1]")
				String textNextToPracticeButton = driver.findElement
						(By.xpath("//div/button[text()='Practice']/following-sibling::button[1]")).getText();
				System.out.println(textNextToPracticeButton);
				
				//child to parent, $x("//div/button[text()='Practice']/parent::div/button[text()='Login']")
				String childToParentText = driver.findElement
						(By.xpath("//div/button[text()='Practice']/parent::div/button[text()='Login']")).getText();
				System.out.println("childToParentText -> "+childToParentText);
			
	}
	
	@Test
	public void practiceScenariosTest()
	{
		WebDriver driver;
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumWebdriver/chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		        //Radio button Example
				//click Radio1
				//driver.findElement(By.cssSelector("input[value='radio1']")).click();
				
				//click Radio2
				driver.findElement(By.cssSelector("input[value='radio2']")).click();	
				
				//Suggestion class example
				WebElement countryTxtBox = driver.findElement(By.id("autocomplete"));
				countryTxtBox.sendKeys("Ind");
				List<WebElement> allElems=driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
				for(WebElement elem : allElems)
				{
					if(elem.getText().equalsIgnoreCase("India"))
					{
						elem.click();
					}
				}
				
				
				
				
				
	}
	
	
	
}
