package auto_Thanh;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex5 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void se() throws InterruptedException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement addFileBtn = driver.findElement(By.xpath("//input[@type='file']"));
		String x0 = "C:\\Users\\An Viet Computer\\Desktop\\automation\\";// duong dan chung

		// duong dan file
		String f1 = x0 + "12.png";
		String f2 = x0 + "bai1.png";
		addFileBtn.sendKeys(f1 + "\n" + f2); // upload File

		Thread.sleep(5000);

		// Verify cac file dc upload
		List<WebElement> list = driver.findElements(By.xpath("//p[@class='name']"));
		for (WebElement File : list) {
			System.out.println("Cac file da upload la: " + File.getText());
		}

		// Doi co dieu kien, den khi e duoc click
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Verify cac file duoc upload thanh cong
		List<WebElement> listuploaded = driver.findElements(By.xpath("//span[@class='preview']/a"));
		for (WebElement Filed : listuploaded) {
			System.out.println("Cac file da upload thanh cong: " + Filed.getAttribute("title"));
		}

		Thread.sleep(10000);
	}

	@Test(enabled = true)
	public void rb() throws InterruptedException, AWTException {

		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		Thread.sleep(5000);

		WebElement addFileBtn = driver.findElement(By.xpath("//span[@class='btn btn-success fileinput-button']"));
		addFileBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-success fileinput-button']")));

		StringSelection slc = new StringSelection("C:\\Users\\An Viet Computer\\Desktop\\automation\\12.png" + "\n"
				+ "C:\\Users\\An Viet Computer\\Desktop\\automation\\bai1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(slc, slc);

		Thread.sleep(10000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// Cac step khac tuong tu nhu tren test1

		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void Au() throws InterruptedException, IOException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement addFileBtn = driver.findElement(By.xpath("//span[@class='btn btn-success fileinput-button']"));
		addFileBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-success fileinput-button']")));

		Thread.sleep(10000);

		Runtime.getRuntime().exec("C:\\Users\\An Viet Computer\\Desktop\\upload.exe");

		// Step con lai nhu test1

		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void s1() throws InterruptedException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		Thread.sleep(5000);

		WebElement addFileBtn = driver.findElement(By.xpath("//input[@type='file']"));
		List<String> filepath = new ArrayList<String>();

		filepath.add("C:\\Users\\An Viet Computer\\Desktop\\automation\\12.png");
		filepath.add("C:\\Users\\An Viet Computer\\Desktop\\automation\\bai1.png");

		Thread.sleep(5000);
		System.out.println(filepath.get(1));
		int i = 0;
		while (i <= 1) {
			addFileBtn.sendKeys(filepath.get(i));
			i = i++;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(10000);
		}

		Thread.sleep(10000);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}