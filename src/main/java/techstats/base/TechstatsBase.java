package techstats.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TechstatsBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TechstatsBase()
	{
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "/resources/config.properties");
			//FileInputStream fip = new FileInputStream("C:\\Users\\Vinayak\\eclipse-workspace\\e2eFramework\\src\\main\\java\\techstats\\config\\config.properties");
			prop.load(fip);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static WebDriver init()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumWebdriver/chromedriver.exe");
			driver= new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public String takeScreenshot(String testcaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFilePath));
		return destinationFilePath;
	}
	
	public WebDriver openApplication()
	{
		driver = init();	
		return driver;
	}
}
