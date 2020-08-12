package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Demo_05 {
	// 
	WebDriver driver;
	String url_ss = "http://www.fb.com/";

	@Test(enabled = false)
	public void link_1() {
		driver.get("http://demo.guru99.com/test/accessing-link.html");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(By.linkText("click here")).click();
		String url_tt = driver.getCurrentUrl();

		if (url_tt.equals(url_ss)) {
			System.out.print("da chuyen trang: Xac dinh bang linktext\n");
		}
	}

	@Test(enabled = true)
	public void link_2() {

		driver.get("http://demo.guru99.com/test/accessing-link.html");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(By.partialLinkText("click")).click();
		String url_tt = driver.getCurrentUrl();

		if (url_tt.equals(url_ss)) {
			System.out.print("da chuyen trang: Xac dinh bang 1 phan \n");
		} else {
			System.out.print("Link chua dung");
		}
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
	}

}
