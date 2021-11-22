package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import reusablecomponents.ReadPropertyFile;

public class TakeScreenShot extends ReadPropertyFile {

	public void getScreenshot(String result) throws IOException {
		java.io.File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./ScreenShot/" + result + System.currentTimeMillis() + ".png"));
	}
}
