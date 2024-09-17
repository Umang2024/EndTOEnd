package Selenium.SeleniumPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class EndToEnd extends BaseClass {
	@Test
	public void Test() throws IOException {
		String userName = "anshikaji@gmail.com";
		String userPassword = "Anshika@123";
		String productName = "ZARA COAT 3";
		LandingPage landingPage = goToURL();
		CatalogPage catalogPage = landingPage.enterUserCredentials(userName, userPassword);
		catalogPage.selectProduct(productName);
		// CartPage
		CartPage cartPage = catalogPage.goToCartPage();
		boolean match = cartPage.verifyProduct(productName);
		Assert.assertTrue(match);
		// CheckoutPage
		CheckoutPage checkoutPage = cartPage.checkOut();
		// ConfirmationPage
		ConfirmationPage confirmationPage = checkoutPage.selectCountry();
		String message = confirmationPage.confirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();

	}
}
