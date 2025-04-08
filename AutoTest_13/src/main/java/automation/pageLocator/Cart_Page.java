package automation.pageLocator;

import java.time.Duration;
import java.util.List;

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

	public void addToCartFunction(String productId) {

		scrollToElement(By.xpath("(//div[@class='productinfo text-center'])["+productId+"]"));
		hoverToElement(By.xpath("(//div[@class='productinfo text-center'])["+productId+"]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addToCartbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='overlay-content']//a[@data-product-id='" +productId+"' and normalize-space(text())='Add to cart']")));
		addToCartbtn.click();
	}

	public void continueShopping() {
		click(By.xpath("//button[contains(text(),'Continue Shopping')]"));
	}

	public void clickViewCart() {
		click(By.xpath("//u[text() = 'View Cart']"));

	}

}
