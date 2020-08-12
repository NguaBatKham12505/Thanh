package auto_Thanh;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BrokenLinks {
	// broken link
	// Tim tat ca cac link trong web (bat dau bang the <a> hoac </img>)
	WebDriver driver;

	@Test(priority = 0)
	public void f() {
		String homePage = "https://www.24h.com.vn";
		driver.get(homePage);

		// Tim tat ca cac link
		List<WebElement> listWeb = driver.findElements(By.tagName("a"));
		listWeb.addAll(driver.findElements(By.tagName("img")));

		Iterator<WebElement> links = listWeb.iterator();
		
		// Cac link broken
		while (links.hasNext()) {
			String url = links.next().getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			try {
				 HttpConnection huc = (HttpConnection)(new URL(url).openConnection());
				 huc.setRequestMethod("Head");
				 huc.connect();
			}
			
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
