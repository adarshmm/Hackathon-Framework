package outlook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewMailPage {
	WebDriver driver;
	//LOGIN page
	By NewMail = By.cssSelector("button[aria-label='New message']");
	By ToEmail = By.cssSelector("input[aria-label='To']");
	By Subject = By.cssSelector("input[aria-label='Add a subject']");
	By BodyInput = By.cssSelector("div[role='textbox']");
	By SendMailButton = By.cssSelector("button[aria-label='Send']");
	
	String EmailId = "adarshmm55@gmail.com";  
    String EmailSubject = "Subject"; 
    String Body = "Body of the email";
	
	public NewMailPage(WebDriver driver){
		this.driver= driver;
	}
	
	public void clickNewMailButton() {
		driver.findElement(NewMail).click();
		
	}
	
	public void enterToEmail() {
		driver.findElement(ToEmail).sendKeys(EmailId);
	}
	
	public void enterSubject() {
		driver.findElement(Subject).sendKeys(EmailSubject);
	}
	
	public void enterBodyContent() {
		driver.findElement(BodyInput).sendKeys(Body);
	}
	
	public void clickSendEmail() {
		driver.findElement(SendMailButton).click();
	}
	
}

package outlook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SentEmailPage {
	WebDriver driver;
	//Sent page
	By SentButton = By.id("O365_AppTile_Mail");
	By SentMail = By.id("//span[contains(text(), 'Sent Items')]");
	
	public SentEmailPage(WebDriver driver){
		this.driver= driver;
	}
	
	public void clickSentButton() {
		driver.findElement(SentButton).click();
		
	}
	
	public void clickSentMail() {
		driver.findElement(SentMail).click();
		
	}
}
