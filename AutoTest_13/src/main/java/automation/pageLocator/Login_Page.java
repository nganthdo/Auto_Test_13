package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Login_Page extends CommonBase {

	private WebDriver driver;

	public Login_Page(WebDriver _driver) {

		this.driver = _driver;
	}
	
	public void LoginFunction(String email, String password) {
		type(By.name("email"), email);
		type(By.name("password"),password);
		click(By.xpath("//button[contains(text(),'Login')]"));
	}

}
