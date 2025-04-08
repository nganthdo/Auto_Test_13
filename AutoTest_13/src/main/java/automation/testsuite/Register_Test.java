package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Register_Page;

public class Register_Test extends CommonBase {
	
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_AUTOEXERCISE);
	}
	
	
	
	
	//Test Case 1: Register User Successfully
	@Test
	public void RegisterSuccessfully() {
		Register_Page register = new Register_Page(driver);
		register.EnterRegisterForm("javaselenium06", "javaselenium06@mailinator.com");
		
		register.EnterAccountInformation("javaselenium06", "123456", "1", "January", "2000");
		register.EnterAddressInformation("java", "selenium", "company IUH", "NJ USA", "LA USA", "United States", "Ohio", "New City", "09110", "0123456789");
		register.RegisterFunction();
		
		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Created!']")));
		
		register.ClickContinueBtn();
		
		assertTrue(isElementDisplay(By.xpath("//a[text()=' Logout']")));

		register.DeleteAccountFunction();
		assertTrue(isElementDisplay(By.xpath("//b[text()='Account Deleted!']")));

	}

	//Test Case 5: Register User with existing email
	@Test
	public void RegisterUnsuccessfully_ExistingEmail() {
		Register_Page register = new Register_Page(driver);
		register.EnterRegisterForm("javaselenium01", "javaselenium01@mailinator.com");
		
		assertTrue(isElementDisplay(By.xpath("//p[text()='Email Address already exist!']")));
		

	}
}
