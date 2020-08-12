package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestNG {
	// Cau truc chung
	WebDriver driver;

	@Test(enabled = true,priority = 1)
	public void f1() {
	}
	@Test(enabled = true,priority = 2)
	public void f2() {
	}
	@Test(enabled = true,priority = 3)
	public void f3() {
	}

	@BeforeTest(enabled = true)
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterTest(alwaysRun =true )
	public void afterTest() {
		driver.quit();
	}

}
