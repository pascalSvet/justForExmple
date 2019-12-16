import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_buy_item {
	
	static WebDriver driver;

	@Before 
	public void closeEnteringPopUp() {	
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Sveta/eclipse/java-2019-09/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		
		driver.get("https://www.zipy.co.il/");

		//close the pop-up window if exist
		if (driver.findElements(By.xpath("//button[@title='Close']")).size() != 0){
			driver.findElement(By.xpath("//button[@title='Close']")).click();
		}	
	}
	
	@After	
	public void closeBrowser() {		
		driver.quit();	// Closing all windows of the browser, opened by the test.		 
	}	
	
	@AfterClass		
	public static void killDriverProcess() throws IOException {		
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");	// Killing the chromedriver process in the end of the test.
	 
	}
	
	@Test		
	public  void buy_fron_search() throws InterruptedException {
		
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@data-user-form='popup_signin']")));
		
		//enter login+password
		driver.findElement(By.id("i_signin-email")).sendKeys("vikos120989@yandex.com", Keys.TAB, "123456", Keys.ENTER);
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='topbar__forms-close']")));
		
		//search for item
		driver.findElement(By.name("keywords")).sendKeys("micro usb", Keys.ENTER);
		new WebDriverWait(driver, 20).until(ExpectedConditions.refreshed((ExpectedConditions.attributeToBe(driver.findElement(By.name("keywords")), "value", "micro usb"))));

		driver.findElement(By.xpath("//a[@href='https://www.zipy.co.il/p/אליאקספרס/rez-micro-usb-cable-usb-charging-cord-mobile-phone-nylon-xiaomi-android-samsung-for-hua-wei/32995752928/']"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("accessibility-variation-select-Color"))).click();
		driver.findElement(By.xpath("//li[@data-index='1']")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("accessibility-variation-select-Length"))).click();
		driver.findElement(By.xpath("//li[@data-index='3']")).click();
		
		//buy
		driver.findElement(By.xpath("//div[@class='add-and-checkout']")).click();


	}
}
