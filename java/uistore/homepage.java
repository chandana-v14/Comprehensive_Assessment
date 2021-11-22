package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	public WebDriver driver;

	public homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='/account/login'])[2]")
	WebElement signin;

	public WebElement signin() {
		return signin;
	}

	
	
	@FindBy(xpath = "//a[@data-dropdown-rel='home-lifestyle']")
	WebElement homeandlife;

	public WebElement homeandlife() {
		return homeandlife;
	}
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement search;

	public WebElement search() {
		return search;
	}
	
	@FindBy(linkText = "Track your order")
	WebElement trackorder;

	public WebElement trackorder() {
		return trackorder;
	}
	
	@FindBy(xpath = "//*[@id='myheader']//div[1]//header//div[2]//div[2]//div[4]//div//div//a[4]")
	WebElement gotoCart;

	public WebElement goCart() {
		return gotoCart;
	}
}
