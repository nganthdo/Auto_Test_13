package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Login_Page;

public class Login_Test extends CommonBase {
	
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_AUTOEXERCISE);
	}
	
	// Test Case 2: Login User with correct email and password
	@Test
	public void LoginSuccessfully() {
		Login_Page login = new Login_Page(driver);
		login.LoginFunction("selpy21@test.com", "123456");
		assertTrue(isElementDisplay(By.xpath("//a[text()=' Logout']")));
	}
	
	// Test Case 3: Login User with incorrect email and password
	@Test
	public void LoginUnsuccessfully_IncorredtEmailPassword() {
		Login_Page login = new Login_Page(driver);
		login.LoginFunction("selpy210@test.com", "1234567");
		assertTrue(isElementDisplay(By.xpath("//p[text()='Your email or password is incorrect!']")));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
