package techstats.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCreate {
	static ExtentReports extent;
	static ExtentSparkReporter reporter;

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\extentReports\\TestReport.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("TestAutomation Results");
		reporter.config().setDocumentTitle("Test Results Web");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA","Auto QA");
		
		return extent;
	}
}
