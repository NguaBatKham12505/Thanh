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

public class Demo_02 {
	// How to Select CheckBox and Radio Button in Selenium WebDriver
	WebDriver driver;
	@Test(enabled =  true )
	public void f() {
		String url="http://demo.guru99.com/test/radio.html";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement radio1=driver.findElement(By.id("vfb-7-1"));
		radio1.click();
		
		WebElement checkbox_01= driver.findElement(By.id("vfb-6-1"));
		checkbox_01.click();
		
		if(radio1.isSelected()) {
			System.out.print("Radio1 da duoc chon r do \n");
		}else {
			System.out.print("Radio1 chua duoc chon vui long chon lai sau");
		}
		
		if(checkbox_01.isSelected()) {
			System.out.print("checkbox1 da duoc chon r do \n");
		}else {
			System.out.print("checkbox1 chua duoc chon vui long chon lai sau");
		}
		
	}

	@BeforeTest(enabled =true )
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterTest(alwaysRun =true )
	public void afterTest() {
		driver.quit();
	}

}
