package uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpagebook {

	public WebDriver driver;

	public searchpagebook(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/products/elly-wooden-bookends']")
	WebElement bookhold;

	public WebElement getBook() {
		return bookhold;
	}

	@FindBy(xpath = "//div[@class='product-single__header small--text-center']//h1")
	WebElement bookname;

	public WebElement getBookname() {
		return bookname;
	}

	@FindBy(xpath = "//*//button[@aria-label='Add to Wishlist']")
	WebElement addwishlist;

	public WebElement toWish() {
		return addwishlist;
	}

	@FindBy(xpath = "//*[@id='myheader']//div[1]//header//div[2]//div[2]//div[4]//div//div//a[2]//span")
	WebElement gowishlist;

	public WebElement goToWish() {
		return gowishlist;
	}

	@FindBy(xpath = "//button[@name='add']")
	WebElement addCart;

	public WebElement toCart() {
		return addCart;
	}

	@FindBy(xpath = "//input[@id='PostalCode']")
	WebElement pincode;

	public WebElement getpin() {
		return pincode;
	}
	
	@FindBy(xpath = "//div[@id='cod-cheker']//button")
	WebElement pincodesrch;

	public WebElement srchpin() {
		return pincodesrch;
	}
	
	@FindBy(xpath = "//*[@id='PostalCodeCheckerAvailability']")
	WebElement codmssg;

	public WebElement chkCOD() {
		return codmssg;
	}
	
	@FindBy(xpath = "//*[@id='AddToCartForm-6806584361158']//div[2]//div//span[1]")
	WebElement plus;

	public WebElement addquant() {
		return plus;
	}
	
	
}
