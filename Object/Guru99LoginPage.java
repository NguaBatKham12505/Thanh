package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99LoginPage {
	WebDriver driver;
	By userGuru99Name = By.name("uid");
	By password99Guru = By.name("password");
	By titleText = By.className("barone");
	By login = By.name("btnLogin");

	public Guru99LoginPage(WebDriver driver) {
		this.driver = driver;
	}

    // Set username
	public void setUserName(String strUserName) {
		driver.findElement(userGuru99Name).sendKeys(strUserName);
	}

	// Set password
	public void setPassWord(String strPassWord) {
		driver.findElement(password99Guru).sendKeys(strPassWord);
	}
	
	// Click login button
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	// Get title Text
	public String getTitleText() {
		return driver.findElement(titleText).getText();
	}
	
	// Login
	public void loginToGuru99(String strUserName,String strPassWord) {
		this.setUserName(strUserName);
		this.setPassWord(strPassWord);
		this.clickLogin();
		
	}

}
