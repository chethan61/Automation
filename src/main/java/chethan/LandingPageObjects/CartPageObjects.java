package chethan.LandingPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import chethan.AbtractMethods.AbstractComponents;

public class CartPageObjects extends AbstractComponents {
	WebDriver driver;
	public CartPageObjects(WebDriver driver){
			super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public void productMatch(String ProductName) {
		boolean bool=cartProducts.stream().anyMatch(g->g.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(bool);
	}
	public PaymentPageObjects checkout() {
		checkout.click();
		PaymentPageObjects pp = new PaymentPageObjects(driver);
		return pp;
	}
}
