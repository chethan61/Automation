package chethan.LandingPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import chethan.AbtractMethods.AbstractComponents;

public class PaymentPageObjects extends AbstractComponents{
	WebDriver driver;
	public PaymentPageObjects(WebDriver driver){
			super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement countryBy(String country) {
	    return driver.findElement(By.xpath(
	        "//button[contains(@class,'ta-item') and normalize-space()='" + country + "']"
	    ));
	}
	@FindBy(css="[placeholder*='Country']")
	WebElement Country;
	@FindBy(css=".action__submit")
	WebElement orderbutton;
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	By results = By.cssSelector(".ta-results");
	public void sendCountry(String country) {
		Country.sendKeys(country);
		waitForElement(results);
		countryBy(country).click();
		orderbutton.click();
		
	}
	public void verifyConfirmMessage() {
		Assert.assertEquals(confirmMessage.getText().toUpperCase().trim(), " Thankyou for the order. ".toUpperCase().trim());
	}
}
