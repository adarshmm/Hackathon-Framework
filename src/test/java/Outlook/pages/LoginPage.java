package Outlook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
		WebDriver driver;
		//LOGIN page
		By SignIn = By.xpath("//*[@id=\"feature-oc387eee\"]/div/div/div[1]/div/div[3]/div[1]/a/span");
		By Username = By.xpath("//*[@id=\"i0116\"]");
		By UsernameNext = By.id("idSIButton9");
		By Password = By.xpath("//*[@id=\"i0118\"]");
		By PasswordNext = By.xpath("//*[@id=\"idSIButton9\"]");
		By StaySignedIn = By.xpath("//*[@id=\"idSIButton9\"]");
		
		
		
		
		public LoginPage(WebDriver driver){
			this.driver= driver;
		}
		
		public void clickSignIn() {
			driver.findElement(SignIn).click();
			
		}
		
		public void enterUsername(String uname) {
			driver.findElement(Username).sendKeys(uname);
			
		}
		
		public void clickUsernameNext() {
			driver.findElement(UsernameNext).click();
			}
		
		public void enterPassword(String passw) {
			driver.findElement(Password).sendKeys(passw);
			
		}
		
		public void clickPasswordNext() {
			driver.findElement(PasswordNext).click();
		}
		
		public void clickStaySignedIn() {
			driver.findElement(StaySignedIn).click();
		}
}

package outlook.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import outlook.pages.LoginPage;
import outlook.pages.NewMailPage;
import outlook.pages.SentEmailPage;
public class TC_sendemail extends BaseClass {
	
	@Test
	public static void tsalesforcesilogin() throws InterruptedException, IOException {
        newmail = new NewMailPage(driver);
        newmail.clickNewMailButton();
        newmail.enterToEmail();
        newmail.enterSubject();
        newmail.enterBodyContent();
        newmail.clickSendEmail();
         
        sentmail = new SentEmailPage(driver);
        sentmail.clickSentButton();
        sentmail.clickSentMail();

        // Wait for the Sent Items page to load (you may need to customize the wait time)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Sent Items"));

        // Verify details of the sent email
        String expectedEmailId = "sender@example.com";  
        String expectedSubject = "Subject"; 
        String expectedBody = "Body of the email";

        // Assert that the sent email is present in the Sent Items
        WebElement sentEmail = driver.findElement(By.xpath("//span[contains(text(), '" + expectedSubject + "')]"));
        assert sentEmail.isDisplayed() : "Email with subject '" + expectedSubject + "' not found in Sent Items.";

        // Assert email ID
        WebElement emailIdElement = driver.findElement(By.xpath("//div[contains(text(), 'From:')]/following-sibling::div"));
        assert emailIdElement.getText().equals(expectedEmailId) : "Incorrect sender email ID.";

        // Assert subject
        assert sentEmail.getText().equals(expectedSubject) : "Incorrect subject.";

        // Assert body
        WebElement emailBodyElement = driver.findElement(By.xpath("//div[@role='main']"));
        assert emailBodyElement.getText().contains(expectedBody) : "Email body does not contain the expected text.";

	}
}

