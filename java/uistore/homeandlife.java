package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homeandlife {

	public WebDriver driver;

	public homeandlife(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Lamps")
	WebElement lamps;

	public WebElement getlamps() {
		return lamps;
	}
	
	@FindBy(xpath ="//*[@id='shopify-section-collection-header']//div//header//h1")
	WebElement title;
	
	public WebElement getlampt() {
		return title;
	}
	
}
