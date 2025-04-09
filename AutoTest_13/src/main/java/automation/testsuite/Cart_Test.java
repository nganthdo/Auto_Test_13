package automation.testsuite;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Cart_Page;
import automation.pageLocator.Login_Page;
import automation.pageLocator.Register_Page;

public class Cart_Test extends CommonBase {

	@BeforeMethod
	public void openBrowser() {

		driver = initBrowser(CT_PageURL.URL_AUTOEXERCISE);
	}

	// verify cart
	public void verifyProductListInCart() {

		List<WebElement> cartList = driver.findElements(By.xpath("//tr[contains(@id, 'product')]"));
		assertEquals(2, cartList.size());

	}

	// Verify price, quantity, total
	public void verifyProductInformationInCart() {
		List<WebElement> cartList = driver.findElements(By.xpath("//tr[contains(@id, 'product')]"));
		for (WebElement product : cartList) {
			String productName = product.findElement(By.xpath("//td[@class='cart_description']")).getText();
			String productPrice = product.findElement(By.xpath("//td[@class='cart_price']")).getText();
			String productQuantity = product.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
			String productTotal = product.findElement(By.xpath("//td[@class='cart_total']")).getText();
			System.out.println("Name: " + productName + ", Price: " + productPrice + ", Quantity: " + productQuantity
					+ ", Total: " + productTotal);

			assertFalse(productPrice.isEmpty());
			assertFalse(productQuantity.isEmpty());
			assertFalse(productTotal.isEmpty());
		}
	}

	// Test Case 12: Add Products in Cart
	@Test
	public void addToCartSuccessfully() {
		Cart_Page cart = new Cart_Page(driver);
		cart.navigateToProductPage();

		cart.addToCartFunction("1");
		assertTrue(isElementDisplay(By.xpath("//p[text()='Your product has been added to cart.']")));

		cart.continueShopping();

		cart.addToCartFunction("2");
		assertTrue(isElementDisplay(By.xpath("//p[text()='Your product has been added to cart.']")));

		cart.clickViewCart();
		verifyProductListInCart();
		verifyProductInformationInCart();

	}

	// Test Case 13: Verify Product quantity in Cart
	@Test
	public void verifyProductQtyInCart() {
		Cart_Page cart = new Cart_Page(driver);
		cart.navigateToProductPage();

		cart.viewDetailProduct();
		cart.addToCartByIncreasingQty("4");
		cart.clickViewCart();

		List<WebElement> cartList = driver.findElements(By.xpath("//tr[contains(@id, 'product')]"));
		for (WebElement product : cartList) {
			String productQuantity = product.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
			System.out.println("Quantity: " + productQuantity);
			assertEquals("4", productQuantity);
			assertFalse(productQuantity.isEmpty());

		}
	}

	// Test Case 14: Place Order: Register while Checkout
	@Test
	public void registerWhileCheckoutSuccessfully() {
		addToCartSuccessfully();
		Cart_Page cart = new Cart_Page(driver);
		cart.clickProceedToCheckout();
		cart.clickRegisterInCheckout();

		Register_Page register = new Register_Page(driver);
		register.EnterRegisterForm("javaselenium09", "javaselenium09@mailinator.com");

		register.EnterAccountInformation("javaselenium09", "123456", "1", "January", "2000");
		register.EnterAddressInformation("java", "selenium", "company IUH", "NJ USA", "LA USA", "United States", "Ohio",
				"New City", "09110", "0123456789");
		register.RegisterFunction();

		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Created!']")));

		register.ClickContinueBtn();

		assertTrue(isElementDisplay(By.xpath("//a[text()=' Logout']")));

		cart.navigateToCartPage();
		cart.clickProceedToCheckout();
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Address Details']")));
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Review Your Order']")));

		cart.enterCheckoutInformation("Call me before shipping! Thanks");
		cart.enterPaymentDetails("helena", "4111111111111111", "123", "12", "2027");

		assertTrue(isElementDisplay(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")));

		register.DeleteAccountFunction();
		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Deleted!']")));

	}

	// Test Case 15: Place Order: Register before Checkout
	@Test
	public void registerBeforeCheckout() {

		Register_Page register = new Register_Page(driver);
		register.EnterRegisterForm("javaselenium09", "javaselenium09@mailinator.com");

		register.EnterAccountInformation("javaselenium09", "123456", "1", "January", "2000");
		register.EnterAddressInformation("java", "selenium", "company IUH", "NJ USA", "LA USA", "United States", "Ohio",
				"New City", "09110", "0123456789");
		register.RegisterFunction();

		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Created!']")));

		register.ClickContinueBtn();

		assertTrue(isElementDisplay(By.xpath("//a[text()=' Logout']")));

		addToCartSuccessfully();
		Cart_Page cart = new Cart_Page(driver);
		cart.clickProceedToCheckout();

		assertTrue(isElementDisplay(By.xpath("//h2[text()='Address Details']")));
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Review Your Order']")));

		cart.enterCheckoutInformation("Call me before shipping! Thanks");
		cart.enterPaymentDetails("helena", "4111111111111111", "123", "12", "2027");

		assertTrue(isElementDisplay(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")));

		register.DeleteAccountFunction();
		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Deleted!']")));

	}

	// Test Case 16: Place Order: Login before Checkout
	@Test
	public void loginBeforeCheckout() {

		Login_Page login = new Login_Page(driver);
		login.LoginFunction("selpy21@test.com", "123456");
		assertTrue(isElementDisplay(By.xpath("//a[text()=' Logout']")));

		addToCartSuccessfully();
		assertTrue(isElementDisplay(By.xpath("//a[text()='Proceed To Checkout']")));

		Cart_Page cart = new Cart_Page(driver);
		cart.clickProceedToCheckout();

		assertTrue(isElementDisplay(By.xpath("//h2[text()='Address Details']")));
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Review Your Order']")));

		cart.enterCheckoutInformation("Call me before shipping! Thanks");
		cart.enterPaymentDetails("helena", "4111111111111111", "123", "12", "2027");

		assertTrue(isElementDisplay(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")));

//		Register_Page register = new Register_Page(driver);
//		register.DeleteAccountFunction();
//		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Deleted!']")));

	}

	// Test Case 17: Remove Products From Cart
	@Test
	public void removeProductFromCart() {

		addToCartSuccessfully();
		Cart_Page cart = new Cart_Page(driver);
		for (int i = 1; i <= 2; i++) {
			cart.removeProductInCartFunction(i);
		}

		assertTrue(isElementDisplay(By.xpath("//b[text()='Cart is empty!']")));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
