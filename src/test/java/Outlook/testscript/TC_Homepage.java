package Outlook.testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import Outlook.pages.HomePage;

public class TC_Homepage extends Basetest{
	@Test
	public static void salesforcehome() throws InterruptedException, IOException {
	
		home=new Outlook.pages.HomePage(driver);
		home.clicklogin();
		//Thread.sleep(2000);
		String Ul =driver.getCurrentUrl();
		System.out.println("done 1");
		if  ("https://login.salesforce.com/?locale=in".equals(Ul)) {
			Assert.assertTrue(true);
			System.out.println("Successfully navigated to login page");
			
		}
		else {
			CaptureScreenshot( driver, "salesforcehome");
			System.out.println("NOT SuccessfulL navigated to login page");
			Assert.assertTrue("https://login.salesforce.com/?locale=in".equals(Ul));
		}
	}
}
