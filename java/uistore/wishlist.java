package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wishlist {

	
	public WebDriver driver;

	public wishlist(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='swym-welcome-button']")
	WebElement access;

	public WebElement getAccess() {
		return access;
	}
}
