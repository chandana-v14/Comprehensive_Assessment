package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class trackorder {

	public WebDriver driver;

	public trackorder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement getmail;

	public WebElement getEmail() {
		return getmail;
	}

	
	
	@FindBy(xpath = "//input[@name='orderNumber']")
	WebElement orderid;

	public WebElement getOrderId() {
		return orderid;
	}
	
	@FindBy(xpath = "//input[@id='ola_submitButton']")
	WebElement find;

	public WebElement getFind() {
		return find;
	}
}
