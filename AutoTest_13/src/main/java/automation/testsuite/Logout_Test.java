package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Login_Page;
import automation.pageLocator.Logout_Page;

public class Logout_Test extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_AUTOEXERCISE);
	}
	
	//Test Case 4: Logout User
	@Test
	public void LogoutSuccessfully() {
		
		Login_Page login = new Login_Page(driver);
		login.LoginFunction("selpy21@test.com", "123456");
		assertTrue(isElementDisplay(By.xpath("//a[text()=' Logout']")));
		
		Logout_Page logout = new Logout_Page(driver);
		logout.LogoutFunction();
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Login to your account']")));

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
