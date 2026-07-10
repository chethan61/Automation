package chethan.AbtractMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		this.driver1=driver;
		this.driver2=driver;
		
	}
	
	public void waitForElement(By findby) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitForElementToDisappear(By findby) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
}
