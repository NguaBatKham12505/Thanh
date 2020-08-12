package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Demo_03 {
	// How to Click on Image in Selenium Webdriver
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		driver.get("https://www.facebook.com/login/identify?ctx=recover");

		Thread.sleep(3000);

		WebElement fb = driver.findElement(By.xpath("//i[@class='fb_logo img sp_R3u_6E07bqo sx_a4c606']"));
		fb.click();

		Thread.sleep(3000);

		String current_url = driver.getCurrentUrl();
		assertEquals(current_url, "https://www.facebook.com/");
	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
