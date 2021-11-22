package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import reusablecomponents.ReadPropertyFile;
import uistore.homepage;



public class viewCart extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void showCart() throws InterruptedException, IOException {

		log.info("Executing viewCart");
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("<<<-navigated to url->>>");

		homepage h = new homepage(driver);

		h.goCart().click();
		log.info("Directed to Cart");
		

	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed viewCart");
	}
}
