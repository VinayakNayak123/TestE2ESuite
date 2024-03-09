package techstats.greenKartTest;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import techstats.base.TechstatsBase;
import techstats.greenKart.HomePage;

public class HomePageTest extends TechstatsBase {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	HomePage homepage;
	
	@BeforeMethod
	public void setUp()
	{
		init();
		homepage= new HomePage();
	}
	
	@Test
	public void searchItemTest()
	{
		homepage.enterTextinSearchBox("Cucumber");
		System.out.println("Cucumber search");
		
	}
	
	@Test
	public void verifyTitle()
	{
		String titleOfPage=homepage.getPageTitle();
		System.out.println(titleOfPage);
		String expected="GreenKart - veg and fruits kart";
		Assert.assertEquals(titleOfPage, expected);
	}

	
	@Test
	public void sampleTestFailure()
	{
	
		Assert.assertTrue(false);
	}
	
	@Test
	public void demoTestFail()
	{
		System.out.println("demoTestFail");
		Assert.assertTrue(false);
	}
	
	@Test
	public void demoTestSecondFail()
	{
		System.out.println("demoTestSecondFail");
		Assert.assertTrue(false);
	}
	

	@Test
	public void loginConsoleTest()
	{
		logger.trace("Trace message");
		logger.info("Info message");
		logger.error("Error message observed...................");
		logger.debug("Debug message");
		logger.trace("Trace message end");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
