package pageobject;

import java.io.IOException;


import org.apache.log4j.Logger;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import reusablecomponents.ReadPropertyFile;
import uistore.homeandlife;
import uistore.homepage;

@SuppressWarnings("deprecation")
public class selectDropdown extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}


	@Test
	public void dropdown() throws InterruptedException, IOException {

		log.info("Executing selectDropdown");
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("<<<-navigated to url->>>");

		homepage h =new homepage(driver);
		
		Actions action = new Actions(driver);

		
		action.moveToElement(h.homeandlife()).perform();
		log.info("Hovered Over Dropdown");
		
		homeandlife hl = new homeandlife(driver);
		hl.getlamps().click();
		
		Assert.assertEquals(hl.getlampt().getText(), "Lamps");
		System.out.println(hl.getlampt().getText());
		log.info("Directed to Lamps page");

	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed selectDropdown");
	}

}