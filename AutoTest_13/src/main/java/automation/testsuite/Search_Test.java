package automation.testsuite;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Search_Page;

public class Search_Test extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_AUTOEXERCISE);
	}

	private void verifySearchResult(String keyword) {
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='productinfo text-center']//p"));
		System.out.println("Total products in searching result: " + searchResult.size());
		for (WebElement product : searchResult) {
			String productName = product.getText().toLowerCase();
			System.out.println(productName);
			assertTrue(productName.contains(keyword), "Product name does not contain keyword: " + productName);
		}

	}

	// Test Case 9: Search Product
	@Test
	public void searchSuccessfully() {
		Search_Page search = new Search_Page(driver);
		search.navigateToSearchPage();

		assertTrue(isElementDisplay(By.xpath("//h2[text()='All Products']")));
		String keyword = "women".toLowerCase();
		search.searchFunction(keyword);
		assertTrue(isElementDisplay(By.xpath("//h2[text()='Searched Products']")));
		verifySearchResult(keyword);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
