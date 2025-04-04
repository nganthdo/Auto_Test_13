package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Logout_Page extends CommonBase {
	private WebDriver driver;

	public Logout_Page(WebDriver _driver) {
		super();
		this.driver = _driver;
	}
	
	public void LogoutFunction() {
		click(By.xpath("//a[text()=' Logout']"));
	}
	
	
}
