package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Demo_01 {
	// TextBox, Submit Button, sendkeys(), click()
	WebDriver driver;

	@Test(enabled = true)
	public void f() throws InterruptedException {

		// Go to url
		driver.get("http://demo.guru99.com/test/login.html");

		Thread.sleep(5000);

		// Element email, password
		WebElement textboxEmail = driver.findElement(By.name("email"));
		WebElement textboxPassword = driver.findElement(By.name("passwd"));
		// email, pass
		textboxEmail.sendKeys("phungthanh.bk@gmail.com");
		textboxPassword.sendKeys("ThanhBK");
		Thread.sleep(3000);
		// Click sign in
		driver.findElement(By.name("SubmitLogin")).click();
	}

	@BeforeTest(enabled = true)
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
		System.out.print("da hoan thanh xong");
	}

}
