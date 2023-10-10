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
package outlook.pages;

public class DeleteMailPage {
	private static void deleteEmail(WebDriver driver, String emailSubject) {
        // Navigate to the Sent Items or Inbox, depending on your use case
        WebElement sentItems = driver.findElement(By.xpath("//span[contains(text(), 'Sent Items')]"));
        sentItems.click();

        // Wait for the Sent Items page to load (you may need to customize the wait time)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Sent Items"));

        // Find and click the email with the specified subject
        WebElement emailToDelete = driver.findElement(By.xpath("//span[contains(text(), '" + emailSubject + "')]"));
        emailToDelete.click();

        // Find and click the delete button (you may need to customize the locator)
        WebElement deleteButton = driver.findElement(By.xpath("//div[@aria-label='Delete']"));
        deleteButton.click();

        // Optionally, you can wait for the email to disappear from the current folder
        wait.until(ExpectedConditions.invisibilityOf(emailToDelete));

        System.out.println("Email with subject '" + emailSubject + "' deleted.");
    }

    private static void checkDeletedItems(WebDriver driver, String emailSubject) {
        // Navigate to the Deleted Items or Trash folder, depending on your use case
        WebElement deletedItems = driver.findElement(By.xpath("//span[contains(text(), 'Deleted Items')]"));
        deletedItems.click();

        // Wait for the Deleted Items page to load (you may need to customize the wait time)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Deleted Items"));

        // Verify that the deleted email is present in Deleted Items
        WebElement deletedEmail = driver.findElement(By.xpath("//span[contains(text(), '" + emailSubject + "')]"));

        // Assert that the deleted email is present in Deleted Items
        assert deletedEmail.isDisplayed() : "Email with subject '" + emailSubject + "' not found in Deleted Items.";

        System.out.println("Email with subject '" + emailSubject + "' found in Deleted Items.");
    }
}
}
