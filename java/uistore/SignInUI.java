package uistore;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInUI {
	
	public static HashMap<String,String> getTestData() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\anany\\Downloads\\Com_Assessment\\ExcelSheet\\Excel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		
		String data=null;
		String data1=null;
		HashMap<String,String> loginArray = new HashMap<String,String>();
		for(int i =0;i<rows;i++) {
			data=sheet.getRow(i).getCell(0).getStringCellValue();
			data1=sheet.getRow(i).getCell(1).getStringCellValue();
			
			loginArray.put(data, data1);
			
		}
		workbook.close();
		
		return loginArray;
	}
	
	
	public WebDriver driver;
	By signin = By.xpath("//*[@id='myheader']/div[1]/header/div[2]/div[2]/div[4]/div/div/a[1]/span");
	By email = By.xpath("//*[@id='CustomerEmail']");
	By password = By.xpath("//*[@id='CustomerPassword']");
	By signButton = By.xpath("//*[@id='customer_login']/p[1]/input");

	public SignInUI(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getSignin() {
		return driver.findElement(signin);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getSigninButton() {
		return driver.findElement(signButton);
	}
}