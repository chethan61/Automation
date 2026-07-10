package chethan.LandingPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chethan.AbtractMethods.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver){
			super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
//	@FindBy(id="toast-container")
//	WebElement toaster;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
//	@FindBy(id="toast-container")
	By toastMessage = By.id("toast-container");
	
	By addButton = By.cssSelector(".card-body button:last-of-type");
	By product = By.cssSelector(".mb-3");
	By spinner = By.cssSelector("toast-container");
	public List<WebElement> getProducts() {
		waitForElement(product);
		return products;
		
	}
	public WebElement getProductsByName(String productName){
		return getProducts().stream().filter(p->p.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	}
	public CartPageObjects addProduct(String productName) {
		getProductsByName(productName).findElement(addButton).click();
		waitForElement(toastMessage);
		waitForElementToDisappear(spinner);
		cartButton.click();
		CartPageObjects cp= new CartPageObjects(driver);
		return cp;
	}
	
	
	
}
