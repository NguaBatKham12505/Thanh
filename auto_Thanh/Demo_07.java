package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Demo_07 {
	// How to Upload & Download a File using Selenium Webdriver
	WebDriver driver;
	String base_url = "http://demo.guru99.com/test/upload/";

	@Test(enabled = false)
	public void senKeys() throws InterruptedException, IOException {
		driver.get(base_url);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadfile_0")));

		driver.findElement(By.xpath("//input[@id='uploadfile_0']")).click();
		Thread.sleep(5000);
		
		// Runtime.getRuntime().exec("C:\\Users\\thanhpv.VSII\\Desktop\\xpath\\demo.exe");

		/*
		 * WebElement xacnhan = driver.findElement(By.id("terms"));
		 * 
		 * xacnhan.click();
		 * 
		 * WebElement up = driver.findElement(By.id("submitbutton")); up.click();
		 * 
		 * Thread.sleep(3000);
		 * 
		 * // xac dinh file da duoc upload hay chua va up bao nhieu WebElement SoFile =
		 * driver.findElement(By.xpath("//h3//center")); //
		 * div[@class='formbuttons']//center String soluong = SoFile.getText();
		 * System.out.print("So luong file da upload la:\n" + soluong);
		 */
	}

	@Test(enabled = false)
	public void AutoIT() throws InterruptedException {
		driver.get(base_url);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement upBtn = driver.findElement(By.id("uploadfile_0"));
		upBtn.sendKeys("C:\\Users\\thanhpv.VSII\\Desktop\\xpath\\Xpath.docx");

		WebElement xacnhan = driver.findElement(By.id("terms"));
		xacnhan.click();

		WebElement up = driver.findElement(By.id("submitbutton"));
		up.click();

		Thread.sleep(3000);

		WebElement SoFile = driver.findElement(By.xpath("//h3//center"));
		// div[@class='formbuttons']//center
		String soluong = SoFile.getText();
		System.out.print("So luong file da upload la:\n" + soluong);
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
