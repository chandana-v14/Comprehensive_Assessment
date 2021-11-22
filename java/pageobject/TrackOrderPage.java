package pageobject;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reusablecomponents.ReadPropertyFile;
import uistore.*;

public class TrackOrderPage extends ReadPropertyFile {

public static Logger log=Logger.getLogger(ReadPropertyFile.class.getName());
	
	@BeforeTest
	public void initialise() throws IOException {
		
		driver=DriverInitialisation();
	}
	
	@Test
	public void TrackOrder() throws InterruptedException {
		
		log.info("Executing TrackOrderPage");
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		log.info("<<<<-navigated to url->>>>");	
		
		homepage h = new homepage(driver);
		h.trackorder().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
	    
		Set<String> ab = driver.getWindowHandles();
		Iterator<String> it = ab.iterator();
		String parentId = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		log.info("Driver switched to Child window");

	    ChromeOptions options  = new ChromeOptions();
	    options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
		
	    trackorder t = new trackorder(driver);
	    
	    t.getEmail().sendKeys("example1@xyz.com");
	    t.getOrderId().sendKeys("476225589");
	    t.getFind().click();
		log.info("Tracking Details Successfuly Entered");

	}
	
	
	@AfterTest
	public void close() {
		
		driver.quit();
		log.info("Executed TrackOrderPage");
	}
	
	
	 

}