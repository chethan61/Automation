package chethan.LandingPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import chethan.AbtractMethods.AbstractComponents;

public class OrderPageObjects extends AbstractComponents {
	WebDriver driver;
	public OrderPageObjects(WebDriver driver){
			super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tbody//td[2]")
	List<WebElement> orderProducts;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public boolean OrderProductMatch(String ProductName) {
		boolean bool=orderProducts.stream().anyMatch(g->g.getText().equalsIgnoreCase(ProductName));
		return bool;
	}
	public PaymentPageObjects checkout() {
		checkout.click();
		PaymentPageObjects pp = new PaymentPageObjects(driver);
		return pp;
	}
}
