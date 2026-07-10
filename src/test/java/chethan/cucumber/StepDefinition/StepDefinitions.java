package chethan.cucumber.StepDefinition;
import chethan.TestComoponents.BaseTest;

import java.io.IOException;

import chethan.LandingPageObjects.CartPageObjects;
import chethan.LandingPageObjects.LandingPageObjects;
import chethan.LandingPageObjects.PaymentPageObjects;
import chethan.LandingPageObjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends chethan.TestComoponents.BaseTest{
	LandingPageObjects lpo;
	ProductCatalogue pc;
	PaymentPageObjects pp;
	@Given("I launch the application")
	public void launch_application() throws IOException {
		lpo = launchApp();
	}
	@Given("I login with (.+) and (.+)$")
	public void I_login_with_username_and_password(String username,String password) {
		pc=lpo.loginApplication(username, password);
		System.out.println(username);
		System.out.println(password);
	}
	@When("^I check (.+) and submit order$")
	public void I_check_product_and_submit_order(String product) {
		CartPageObjects cp=pc.addProduct(product);
		 pp=	cp.checkout();
		pp.sendCountry("India");
	}
	@Then("I verify \" Thankyou for the order. \" message")
	public void I_verify_Thankyou_for_the_order_message() throws IOException {
		pp.verifyConfirmMessage();
		terminate();
	}
}
