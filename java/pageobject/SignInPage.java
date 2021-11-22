package pageobject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusablecomponents.ReadPropertyFile;
import uistore.SignInUI;

public class SignInPage extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void SignIn() throws InterruptedException, IOException {

		log.info("Executing SignInPage");
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("<<<-navigated to url->>>");

		SignInUI s = new SignInUI(driver);
		HashMap<String, String> data = s.getTestData();
		System.out.println(data.get(0));
		log.info("Retreived value from Excel sheet");
		
		s.getSignin().click();
		Thread.sleep(5000);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
		
		for (Entry<String, String> entry : data.entrySet()) {
			s.getEmail().sendKeys(entry.getKey());

			s.getPassword().sendKeys(entry.getValue());

		}

		s.getSigninButton().click();
		log.info("Successfuly submitted sign-in details");
	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;
		log.info("Executed SignInPage");
	}

}