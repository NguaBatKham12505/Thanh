package Test_object;

import org.testng.annotations.Test;

import Object.TravelCompainHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TravelCompainTcs {

	WebDriver driver;
	String ComepainHomepage = "https://www.path2usa.com/travel-companions";
	String thangDuKien = "May";
	String ngayDuKien = "3";

	@Test(enabled = true)
	public void selectDate() throws Exception {
		// Go to HomePage
		driver.get(ComepainHomepage);

		Thread.sleep(10000);

		// Scroll to date picker and click next button
		TravelCompainHomePage HP = new TravelCompainHomePage(driver);
		HP.ScrollInTo();
		HP.clickDatepicker();

		// Select month
		while (!HP.getTextMonth().contains(thangDuKien)) {
			HP.clickNextBtn();
		}

		Thread.sleep(3000);

		// Select date
		List<WebElement> dateActive = driver.findElements(By.className("day"));
		int n = dateActive.size();
		for (int i = 0; i < n; i++) {
			String textDay = dateActive.get(i).getText();
			if (textDay.equalsIgnoreCase(ngayDuKien)) {
				dateActive.get(i).click();
				System.out.println("Ngay:" + textDay);
				break;
			}
		}

		Thread.sleep(5000);

	}

	@BeforeTest(enabled = true)
	public void beforeTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
