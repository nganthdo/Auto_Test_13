package automation.testsuite;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Cart_Page;

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

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
