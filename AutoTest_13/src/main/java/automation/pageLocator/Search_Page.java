package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Search_Page extends CommonBase {

	private WebDriver driver;

	public Search_Page(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void navigateToSearchPage() {
		click(By.xpath("//a[text()=' Products']"));
	}
	
	public void searchFunction(String keywordSearch) {
		
		type(By.id("search_product"), keywordSearch);
		click(By.id("submit_search"));
		
	}
	
}
