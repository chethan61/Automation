package chethan.SeleniumFrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import chethan.LandingPageObjects.CartPageObjects;
import chethan.LandingPageObjects.LandingPageObjects;
import chethan.LandingPageObjects.OrderPageObjects;
import chethan.LandingPageObjects.PaymentPageObjects;
import chethan.LandingPageObjects.ProductCatalogue;
import chethan.TestComoponents.BaseTest;

public class SubmitOrder extends BaseTest {
	

	@Test(dataProvider = "getData",groups={"purchaseOrder"})
//	public void addToCart(String email,String password,String product) throws IOException {
	public void addToCart(HashMap<String,String> input) throws IOException {
		ProductCatalogue pc = lpo.loginApplication(input.get("email"), input.get("password"));
		CartPageObjects cp = pc.addProduct(input.get("product"));
		cp.productMatch(input.get("product"));
		PaymentPageObjects pp = cp.checkout();
		pp.sendCountry("China");
		
	}
	@Test(dependsOnMethods= {"addToCart"})
	public void orderItemVerification() {
		ProductCatalogue pc = lpo.loginApplication("chethan1@gmail.com", "Chaithu@3");
		OrderPageObjects ob = lpo.Ordersclick();
		Assert.assertTrue(ob.OrderProductMatch("ZARA COAT 3"));
	}
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> hm = new HashMap <String,String>(); 
//		hm.put("email", "chethan1@gmail.com");
//		hm.put("password", "Chaithu@3");
//		hm.put("product", "ZARA COAT 3");
//		HashMap<String,String> hm1 = new HashMap <String,String>(); 
//		hm1.put("email", "chethan12@gmail.com");
//		hm1.put("password", "Chaithu@mpl4");
//		hm1.put("product", "ADIDAS ORIGINAL");
//		return new Object[][] {{hm},{hm1}};
		List<HashMap<String, String>> data= getJsonData();
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
//		return new Object[][] {{"chethan1@gmail.com","Chaithu@3","ZARA COAT 3"},{"chethan12@gmail.com","Chaithu@mpl4","ADIDAS ORIGINAL"}};
	}

}
