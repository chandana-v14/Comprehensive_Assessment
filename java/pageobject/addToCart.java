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

@SuppressWarnings("deprecation")
public class addToCart extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void addCart() throws InterruptedException, IOException {

		log.info("Executing addToCart");
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
		log.info("Found Item");
		sb.toCart().click();
		log.info("Added To Cart");
		
		

	}

	@AfterTest
	public void close() {

		
		driver.close();
		driver = null;
		log.info("Executed addToCart");
		
	}
}
