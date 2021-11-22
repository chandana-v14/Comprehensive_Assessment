package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import reusablecomponents.ReadPropertyFile;
import uistore.homepage;
import uistore.searchpagebook;

@SuppressWarnings("deprecation")
public class checkCODbyPin extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void checkCOD() throws InterruptedException, IOException {

		
		log.info("Executing checkCODbyPin");
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
		Thread.sleep(500);
		
		sb.getpin().click();
		sb.getpin().sendKeys("560097");
		sb.srchpin().click();
		Thread.sleep(2000);
		log.info("Searched pincode");
		
		Assert.assertEquals(sb.chkCOD().getText(), "Cash on Delivery is available.");
		System.out.println(sb.chkCOD().getText());
		log.info("Validated COD Availability");
	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed checkCODbyPin");

	}

}
