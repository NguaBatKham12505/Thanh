package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Demo_04 {
	// How to Select Value from DropDown using Selenium Webdriver
	WebDriver driver;

	@Test(enabled =true )
	public void f() {
		String url=" http://jsbin.com/osebed/2";
		driver.get(url);
		Select fruit= new Select(driver.findElement(By.id("fruits")));
		fruit.selectByVisibleText("Apple");
		driver.findElement(By.xpath("//option[@value='apple']")).isSelected();
	}

	@BeforeTest(enabled =true )
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}

