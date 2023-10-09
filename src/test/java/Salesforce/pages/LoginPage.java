package Salesforce.pages;

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
