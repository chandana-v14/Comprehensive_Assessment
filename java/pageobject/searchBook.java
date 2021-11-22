package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusablecomponents.ReadPropertyFile;
import uistore.homepage;

public class searchBook extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}


	@Test
	public void searchItem() throws InterruptedException, IOException {

		log.info("Executing searchBook");
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("<<<-navigated to url->>>");

		
		homepage h = new homepage(driver);
		
		h.search().sendKeys("Books");
		h.search().sendKeys(Keys.ENTER);
		log.info("Books Page Displayed");
	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed searchBook");
	}

}
