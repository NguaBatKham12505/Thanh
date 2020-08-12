package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Demo_10 {
	// Handling Dynamic Web Tables Using Selenium WebDriver
	WebDriver driver;

	@Test(enabled = true)
	public void locateWebTable() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/web-table-element.php#");
		
		Thread.sleep(3000);
		
		List<WebElement> rol=driver.findElements(By.xpath("//tbody//tr"));
		System.out.println("So dong: "+rol.size()+"\n");
		
		List<WebElement> col= driver.findElements(By.xpath("//tbody//tr[1]//td"));
		System.out.println("So cot: "+col.size()+"\n");
	}
	@Test(enabled = false)
	public void DynamicTable() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/web-table-element.php#");
		
		Thread.sleep(3000);
		
		List<WebElement> rol=driver.findElements(By.xpath("//tbody//tr"));
		System.out.println("So dong: "+rol.size()+"\n");
		
		List<WebElement> col= driver.findElements(By.xpath("//tbody//tr[1]//td"));
		System.out.println("So cot: "+col.size()+"\n");
	}

	@BeforeTest(enabled = true)
	public void beforeTest() {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		//driver = new ChromeDriver();
		//driver= new InternetExplorerDriver();
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterTest(alwaysRun =true )
	public void afterTest() {
		driver.quit();
	}

}
