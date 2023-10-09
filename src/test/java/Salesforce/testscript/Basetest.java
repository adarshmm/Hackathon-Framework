package Salesforce.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Salesforce.pages.HomePage;
import Salesforce.pages.LoginPage;
import Salesforce.pages.TryforfreePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public static WebDriver driver;
	public static HomePage home;
	public static LoginPage login;
	public static TryforfreePage signup;
	public static FileInputStream fileLoc; 
	public static Properties prop;
	public static Properties propsignup;
	public static FileInputStream fileLoc2;
	
	@BeforeSuite
	public void settingup() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
		
		driver.get("https://outlook.live.com/mail");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		
		fileLoc = new FileInputStream("C:\\Users\\ADARSH M M\\eclipse-workspace\\Framework\\src\\test\\java\\testDAta\\login.properties");
		prop = new Properties();
		prop.load(fileLoc);
		
		fileLoc2 = new FileInputStream("C:\\Users\\ADARSH M M\\eclipse-workspace\\Framework\\src\\test\\java\\testDAta\\signup.properties");
		propsignup = new Properties();
		propsignup.load(fileLoc2);
		
	}
	public static void  CaptureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destifile = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		//String absolutepath = destifile.getAbsolutePath();
		FileUtils.copyFile(srcfile, destifile);
		
		//return absolutepath;
	}
	
	@AfterSuite
	public void last() {
//		driver.quit();
	}

}
