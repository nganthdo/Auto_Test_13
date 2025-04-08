package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Subscription_Page;

public class Subscription_Test extends CommonBase {
	
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_AUTOEXERCISE);
	}
	
	// Test Case 10: Verify Subscription in home page
	@Test
	public void subscriptionInHomePageSuccessfully() {
		Subscription_Page subscription = new Subscription_Page(driver);
		subscription.navigateToHomepage();
		String subEmail = "testersel@mailinator.com";
		scrollToElement(By.xpath("//h2[text()='Subscription']"));
		subscription.subscriptionFunction(subEmail);
		
		WebElement successMsg = driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));
		assertTrue(isElementDisplay(By.xpath("//div[text()='You have been successfully subscribed!']")));
		assertEquals("You have been successfully subscribed!",successMsg.getText());
	}
	
	// Test Case 11: Verify Subscription in Cart page
	@Test
	public void subscriptionInCartPageSuccessfully() {
		Subscription_Page subscription = new Subscription_Page(driver);
		subscription.navigateToCartpage();
		
		String subEmail = "testersel@mailinator.com";
		scrollToElement(By.xpath("//h2[text()='Subscription']"));
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Subscription']")));
		
		subscription.subscriptionFunction(subEmail);
		
		WebElement successMsg = driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));
		assertTrue(isElementDisplay(By.xpath("//div[text()='You have been successfully subscribed!']")));
		assertEquals("You have been successfully subscribed!",successMsg.getText());
	}
	
	

}
