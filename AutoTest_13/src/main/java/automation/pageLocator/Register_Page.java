package automation.pageLocator;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import automation.common.CommonBase;

public class Register_Page extends CommonBase {

	private WebDriver driver;

	public Register_Page(WebDriver _driver) {
		this.driver = _driver;
	}

	public void EnterRegisterForm(String name, String email) {
		type(By.xpath("//input[@data-qa='signup-name']"), name);
		type(By.xpath("//input[@data-qa='signup-email']"), email);
		click(By.xpath("//button[contains(text(),'Signup')]"));

	}

	public String randomGender() {
		String[] gender = {"id_gender1","id_gender2"};
		Random random = new Random();
		return gender[random.nextInt(gender.length)];
		
	}
	
	public void EnterAccountInformation(String name, String password, String bday, String bmonth, String byear) {


		click(By.xpath("//input[@id='" +randomGender()+ "']"));

		type(By.xpath("//input[@id='name']"), name);

		type(By.xpath("//input[@id='password']"), password);

		select(By.id("days"), bday);
		select(By.id("months"), bmonth);
		select(By.id("years"), byear);

		click(By.xpath("//input[@id='newsletter']"));
		click(By.xpath("//input[@id='optin']"));

	}

	public void EnterAddressInformation(String firstname, String lastname, String company, String address1,
			String address2, String country, String state, String city, String zipcode, String phone) {

		type(By.xpath("//input[@id='first_name']"), firstname);
		type(By.xpath("//input[@id='last_name']"), lastname);
		type(By.xpath("//input[@id='company']"), company);
		type(By.xpath("//input[@id='address1']"), address1);
		type(By.xpath("//input[@id='address2']"), address2);

		Select selectedCountry = new Select(driver.findElement(By.id("country")));
		selectedCountry.selectByVisibleText(country);

		type(By.xpath("//input[@id='state']"), state);
		type(By.xpath("//input[@id='city']"), city);
		type(By.xpath("//input[@id='zipcode']"), zipcode);
		type(By.xpath("//input[@id='mobile_number']"), phone);

	}

	public void RegisterFunction() {
		click(By.xpath("//button[contains(text(),'Create Account')]"));

	}

	public void ClickContinueBtn() {
		click(By.xpath("//a[contains(text(),'Continue')]"));
	}

	public void DeleteAccountFunction() {

		click(By.xpath("//a[contains(text(),' Delete Account')]"));
	}

}
