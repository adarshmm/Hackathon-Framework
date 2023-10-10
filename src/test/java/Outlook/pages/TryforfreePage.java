package Outlook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TryforfreePage {
	WebDriver driver;
	//SignUP page
	By Firstname = By.name("UserFirstName");
	By Lastname = By.name("UserLastName");
	By Workemail = By.name("UserEmail");
	By Company = By.name("CompanyName");
	By Phone = By.name("UserPhone");
	By PolicyAgreement = By.xpath("/html/body/div[3]/div[1]/div/div[6]/div[1]/div[2]/div/div/div[2]/div/div/div/form/div[5]/div/div/div[1]");
	By StartTrial = By.xpath("/html/body/div[3]/div[1]/div/div[6]/div[1]/div[2]/div/div/div[2]/div/div/div/form/div[13]/button");
	By JOBtitle = By.name("UserTitle");
	By contact = By.xpath("/html/body/footer/div/div[1]/div/div/div/div/div[2]/nav/ul/li[6]/a");
	
	public TryforfreePage(WebDriver d) {
		driver = d;
		
	}
	public void enterFirstname(String fname) {
		driver.findElement(Firstname).sendKeys(fname);
	}
	public void enterLastname(String lname) {
		driver.findElement(Lastname).sendKeys(lname);
	}
	public void enterWorkmail(String wmail) {
		driver.findElement(Workemail).sendKeys(wmail);
	}
	public void enterCompany(String company) {
		driver.findElement(Company).sendKeys(company);
	}
	public void enterPhone(String Ph) {
		driver.findElement(Phone).sendKeys(Ph);
		
	}
	public void clickPolicyAgreement() {
		driver.findElement(PolicyAgreement).click();
	}
	public void clickStartTrial () {
		driver.findElement(StartTrial).click();
	}
	public void selectJOBtitle(String JOB) {
		WebElement jtitle = driver.findElement(JOBtitle);
		Select jtitle1 = new Select(jtitle);
		jtitle1.selectByVisibleText(JOB);
	}
	public void clickcontact() {
	driver.findElement(contact).click();
	}
	
	
	

	
	




}
