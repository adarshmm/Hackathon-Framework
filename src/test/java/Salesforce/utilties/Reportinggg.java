package Salesforce.utilties;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportinggg extends TestListenerAdapter {
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	WebDriver driver;
	
	public void onStart (ITestContext testContext) {
		System.out.println("Test Started");
		LocalDate idt = LocalDate.now();
		System.out.println(idt);
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+idt+"   000000.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test passed");
		test= extent.createTest(tr.getName());
		test.pass("The test is passed");
		
		
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test failed");
		test= extent.createTest(tr.getName());
		test.fail("failed");
		String ssPath = System.getProperty("user.dir")+"/screenshots/"+tr.getName()+".png";
		File file = new File(ssPath);
		test.fail("test failed "+test.addScreenCaptureFromPath(ssPath));
		

		
	}
	
	public void onSkipped(ITestResult tr) {
		System.out.println("Test skipped");
		test= extent.createTest(tr.getName());
		test.skip("skipped");
		
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
	}
	
	
	


	




}
