package chethan.SeleniumFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import chethan.LandingPageObjects.CartPageObjects;
import chethan.LandingPageObjects.ProductCatalogue;
import chethan.TestComoponents.BaseTest;
import chethan.TestComoponents.iRetry;

public class ErrorValidations extends BaseTest{	
	@Test(groups= {"abcd"},retryAnalyzer=iRetry.class)
	public void loginError() {
		lpo.loginApplication("chethan1@gmail.com", "Chaithu@");
		Assert.assertEquals(lpo.errorMessage().trim(),"Incorrect email or password. ");
		
		
	}
	@Test(groups= {"abc"})
	public void productValidationError() {
		ProductCatalogue pc = lpo.loginApplication("chethan1@gmail.com", "Chaithu@3");
		CartPageObjects cp = pc.addProduct("ZARA COAT 3");
		cp.productMatch("ZARA COAT 33");
	}
}
