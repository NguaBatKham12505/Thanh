package Test_object;

import org.testng.annotations.Test;

import Object.Guru99HomePage;
import Object.Guru99LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Guru99SimplePOMTestcase {

	WebDriver driver;
	Guru99LoginPage objLoginPage;
	Guru99HomePage objHomePage;

	@Test(enabled = true, priority = 0)
	public void f() throws InterruptedException {
		driver.get("http://demo.guru99.com/V4/");
		objLoginPage = new Guru99LoginPage(driver);
		String loginPageTiTle = objLoginPage.getTitleText();
		System.out.println("Ket qua 1:" + loginPageTiTle.equals("Guru99 Bank"));

		// Login
		objLoginPage.loginToGuru99("mgr123", "mgr!23");

		// Wait 5 seconds
		Thread.sleep(5000);

		// Verify
		objHomePage = new Guru99HomePage(driver);
		String DashBoard = objHomePage.getHomePageDashBoardUserName();
		Assert.assertTrue(DashBoard.equals("manger id : mgr123"));

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
