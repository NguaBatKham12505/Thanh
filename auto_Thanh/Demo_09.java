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

public class Demo_09 {
	// How to Handle Web Table in Selenium WebDriver
	WebDriver driver;

	@Test(enabled = true)
	public void f_01() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/write-xpath-table.html");
		
		Thread.sleep(3000);
		
		// Locate Element
		WebElement o1=driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
		String text_o1=o1.getText();
		WebElement o2=driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
		String text_o2=o2.getText();
		WebElement o3=driver.findElement(By.xpath("//tbody/tr[2]/td[1]"));
		String text_o3=o3.getText();
		WebElement o4=driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		String text_o4=o4.getText();
		
		// In
		System.out.println("Text 1 la:"+text_o1+"\n");
		System.out.println("Text 2 la:"+text_o2+"\n");
		System.out.println("Text 3 la:"+text_o3+"\n");
		System.out.println("Text 4 la:"+text_o4+"\n");
		
	}
	
	
	@Test(enabled = true)
	public void f_02() {
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
