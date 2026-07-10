package chethan.LandingPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chethan.AbtractMethods.AbstractComponents;

public class LandingPageObjects extends AbstractComponents{
	WebDriver driver;
	public LandingPageObjects(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement loginButton;
//	@FindBy(css="[class*='flyInOut']")
//	WebElement erroMessage;
	By errorMessage = By.cssSelector("[class*='flyInOut']");
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersButton;

public ProductCatalogue loginApplication(String email,String password) {
	userEmail.sendKeys(email);
	userPassword.sendKeys(password);
	loginButton.click();
	ProductCatalogue pc = new ProductCatalogue(driver);
	return pc;
}
public void goTo(String url) {
	driver.get(url);
}
public String errorMessage() {	
	waitForElement(errorMessage);
	return driver.findElement(errorMessage).getText();
}
public OrderPageObjects Ordersclick() {
	OrderPageObjects ob = new OrderPageObjects(driver);
	ordersButton.click();
	return ob;
}

}
