package Outlook.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import Outlook.pages.HomePage;
import Outlook.pages.LoginPage;
import Outlook.pages.TryforfreePage;

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
	@BeforeClass
	public void login() throws InterruptedException {
		login = new LoginPage(driver);
		login.clickSignIn();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(2000);
		login.enterUsername(prop.getProperty("Username"));
		Thread.sleep(5000);
		login.clickUsernameNext();
		Thread.sleep(5000);
		login.enterPassword(prop.getProperty("Password"));
		Thread.sleep(5000);
		login.clickPasswordNext();
		Thread.sleep(2000);
		login.clickStaySignedIn();
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
