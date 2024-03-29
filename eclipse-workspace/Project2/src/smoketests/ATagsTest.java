package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
  
WebDriver driver;
	
	@Test
	public void aTagsLinksTest() {
	boolean createAccountPresent = false;
	
	List <WebElement> aElements = driver.findElements(By.tagName("a"));
	
	int numberOfElements = aElements.size();
	System.out.println("There are " + numberOfElements + " a tags on the page");
	
	for (WebElement aElement : aElements) {
		System.out.println(aElement.getText());
		if (aElement.getText().equals("CREATE ACCOUNT")) {
			createAccountPresent = true;
			break;
		}
	}
	
	Assert.assertTrue(createAccountPresent);
	
	}
	
	@BeforeMethod
	public void setUp() {
	String webURL = ("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	driver = utilities.DriverFactory.open("chrome");
	driver.get(webURL);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
