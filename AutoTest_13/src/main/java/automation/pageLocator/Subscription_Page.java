package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Subscription_Page extends CommonBase {
	
	private WebDriver driver;

	public Subscription_Page(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void navigateToHomepage() {
		click(By.xpath("//a[text()=' Home']"));
	}
	
	public void subscriptionFunction(String emailSub) {
		
		type(By.id("susbscribe_email"), emailSub);
		click(By.id("subscribe"));
	}
	
	public void navigateToCartpage() {
		click(By.xpath("//a[text()=' Cart']"));
	}
	

}
