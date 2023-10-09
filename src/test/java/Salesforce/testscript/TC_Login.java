package Salesforce.testscript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Salesforce.pages.HomePage;
import Salesforce.pages.LoginPage;
public class TC_Login extends TC_Homepage {
	
	@Test
	public static void tsalesforcesilogin() throws InterruptedException, IOException {
		login = new LoginPage(driver);
		login.clickSignIn();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab
//        for (String windowHandle : windowHandles) {
//            if (!windowHandle.equals(driver.getWindowHandle())) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
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
		
		
		String Ul =driver.getCurrentUrl();
		System.out.println("done LOGIN");
		
		//driver.quit();
		
		
	}
}
