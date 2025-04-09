package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class Cart_Page extends CommonBase {

	private WebDriver driver;

	public Cart_Page(WebDriver _driver) {
		this.driver = _driver;
	}

	public void navigateToProductPage() {
		click(By.xpath("//a[text()=' Products']"));

	}
	
	public void navigateToCartPage() {
		click(By.xpath("//a[text()=' Cart']"));

	}

	public void addToCartFunction(String productId) {

		scrollToElement(By.xpath("(//div[@class='productinfo text-center'])["+productId+"]"));
		hoverToElement(By.xpath("(//div[@class='productinfo text-center'])["+productId+"]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addToCartbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-overlay']//a[@data-product-id='" +productId+"' and normalize-space(text())='Add to cart']")));
		addToCartbtn.click();
	}

	public void continueShopping() {
		click(By.xpath("//button[contains(text(),'Continue Shopping')]"));
	}

	public void clickViewCart() {
		click(By.xpath("//u[text() = 'View Cart']"));

	}
	
	public void viewDetailProduct() {
		click(By.xpath("(//a[text()='View Product'])[1]"));
	}
	
	public void addToCartByIncreasingQty(String productQty) {
		type(By.id("quantity"),productQty);
		click(By.xpath("//button[contains(normalize-space(),'Add to cart')]"));
		
	}
	
	public void clickProceedToCheckout() {
		click(By.xpath("//a[text()='Proceed To Checkout']"));
		
	}
	
	public void clickRegisterInCheckout() {
		click(By.xpath("//u[text()='Register / Login']"));
	}
	
	public void enterCheckoutInformation(String checkoutMsg) {
		type(By.name("message"),checkoutMsg);
		click(By.xpath("//a[text()='Place Order']"));
	}
	
	public void enterPaymentDetails(String cardName, String cardNumber, String cvc, String expMonth, String expYear) {
		type(By.name("name_on_card"),cardName);
		type(By.name("card_number"),cardNumber);
		type(By.name("cvc"),cvc);
		type(By.name("expiry_month"),expMonth);
		type(By.name("expiry_year"),expYear);

		
		click(By.id("submit"));
	}
	
	public void removeProductInCartFunction(int productId) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement removeIcon =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart_quantity_delete' and @data-product-id = '" +productId+ "']")));
		removeIcon.click();
	}
	

}
