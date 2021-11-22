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
public class add3Quantity extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void addQuant() throws InterruptedException, IOException {

		log.info("Executing add3Quantity");
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
		
		sb.addquant().click();
		sb.addquant().click();
		log.info("Added 3 Quantities");
		

	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed add3Quantities");
		

	}
}
