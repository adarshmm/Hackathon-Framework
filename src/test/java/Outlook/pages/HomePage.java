package Outlook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;
	
	//Home Page
	By login =By.xpath("//*[@id=\"globalnavbar-header-container\"]/div[2]/div/div[6]/div/div/div[1]/a");
	By watchNOW = By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[5]/div/div[2]/div[1]/div/div[6]/div[1]/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div/a");
	By tryFORfree =By.xpath("//*[@id=\"globalnavbar-header-container\"]/div[3]/div/div/div/a");
	By ContactUS = By.xpath("//*[@id=\"globalnavbar-header-container\"]/div[2]/div/div[3]/a");
	
	
	public HomePage (WebDriver d){
		driver=d;
	}
	
	public void clicklogin() {
		driver.findElement(login).click();
	}
	public void clickwatchNOW() {
		driver.findElement(watchNOW).click();
	}
	public void clicktryFORfree() {
		driver.findElement(tryFORfree).click();
	}
	public void clickContactUS() {
		driver.findElement(ContactUS).click();
	}




}
