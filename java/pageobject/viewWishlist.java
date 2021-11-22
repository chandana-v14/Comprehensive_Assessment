package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import reusablecomponents.ReadPropertyFile;
import uistore.homepage;
import uistore.searchpagebook;
import uistore.wishlist;

@SuppressWarnings("deprecation")
public class viewWishlist extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void viewWish() throws InterruptedException, IOException {

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("<<<-navigated to url->>>");

		homepage h = new homepage(driver);

		h.search().sendKeys("Books");
		h.search().sendKeys(Keys.ENTER);

		searchpagebook sb = new searchpagebook(driver);

		sb.getBook().click();
		Assert.assertEquals(sb.getBookname().getText(), "Elly Wooden Bookends");
		Thread.sleep(500);
		sb.toWish().click();
		Thread.sleep(500);
		sb.goToWish().click();
		Thread.sleep(1000);
		
		wishlist w = new wishlist(driver);
		
		w.getAccess().click();
		log.info("Directed to wishlist");
	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed viewWishlist");

	}
}