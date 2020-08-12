package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Demo_08 {
	// Alert & Popup Window Handling in Selenium WebDriver

	WebDriver driver;

	@Test(enabled = false)
	public void Alert() throws InterruptedException {
		// Homepage
		String baseurl = "http://demo.guru99.com/test/delete_customer.php";
		driver.get(baseurl);

		// wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Locate element
		WebElement textbox = driver.findElement(By.name("cusid"));
		WebElement submitBtn = driver.findElement(By.name("submit"));

		// Actions
		Random rd = new Random();
		int so = rd.nextInt((100 - 0) + 1) + 0;
		String i = String.valueOf(so); //ep kieu sang string

		String cus_ID = "Thanh" + i;

		textbox.sendKeys(cus_ID);
		submitBtn.click();

		Thread.sleep(3000);

		// Alert_1
		Alert alert = driver.switchTo().alert();
		String alertNotificaton_1 = alert.getText();
		alert.accept();

		Thread.sleep(3000);

		// Alert_2
		String alertNotification_2 = alert.getText();
		alert.accept();

		System.out.print("Thong bao 1:" + alertNotificaton_1 + "\n");

		System.out.print("Thong bao 1:" + alertNotification_2 + "\n");

	}

	@Test(enabled = true)
	public void multiWindow() throws InterruptedException {
		String url = "http://demo.guru99.com/popup.php";
		driver.get(url);

		WebElement newW = driver.findElement(By.xpath("//a[text()='Click Here']"));
		newW.click();

		Set<String> windows = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(windows);
		System.out.print("Cac thanh phan trong list:" + list+"\n");
		
		driver.switchTo().window(list.get(0));
		System.out.print("Cac thanh phan trong list:" + driver.getWindowHandle()+"\n");

		Thread.sleep(10000);
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
