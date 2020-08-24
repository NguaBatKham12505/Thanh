package Object;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelCompainHomePage {
	@FindBy(id = "travel_date")
	@CacheLookup
	WebElement datepicker;
	
	@FindBy(className = "next")
	@CacheLookup
	WebElement nextBtn;
	
	@FindBy(className = "datepicker-switch")
	WebElement monthYear;

	WebDriver driver;

	public TravelCompainHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// sCroll into 
	public void ScrollInTo() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", datepicker);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	// Click datepicker
	public void clickDatepicker() {
		datepicker.click();
	}
	// Click next button
	public void clickNextBtn() {
		nextBtn.click();
	}
	// Get month/year
	public String getTextMonth() {
		String textMonth= monthYear.getText();
		return textMonth;
	}

}
