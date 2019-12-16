import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class tests_try1B {

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
	public  void login_by_email() throws InterruptedException {
		
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@data-user-form='popup_signin']")));
		
		//enter login+password
		driver.findElement(By.id("i_signin-email")).sendKeys("pascalsvet@gmail.com", Keys.TAB, "zipi7171", Keys.ENTER);
		new WebDriverWait(driver, 18).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='topbar__forms-close']")));
		
		// if we logged in, there is a new button, named - אזור אישי
		Assert.assertTrue(driver.findElement(By.id("topbar")).getText().contains("אזור אישי"));
		
	}
	
	@Test		
	public  void login_by_FB() throws InterruptedException {
		
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@data-user-form='popup_signin']")));
		
		//choose with-facebook and switch to new-login-window
		driver.findElement(By.xpath("//span[@title='Facebook']")).click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle); 
        }
		//enter login+password
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("0524555436", Keys.TAB, "fb7171", Keys.ENTER);
		
		//if it's a first login with facebook, confirm it:
		//wait.until(ExpectedConditions.elementToBeClickable(By.name("__CONFIRM__"))).click();
		
		//back to the main window and wait for the login-window to close
		driver.switchTo().window(winHandleBefore);
		new WebDriverWait(driver, 18).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='topbar__forms-close']")));
		
		// if we logged in, there is a new button, named -אזור אישי
		Assert.assertTrue(driver.findElement(By.id("topbar")).getText().contains("אזור אישי"));
		
	}

	@Test		
	public  void login_by_google() throws InterruptedException {
		
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@data-user-form='popup_signin']")));
		
		//choose with-google and switch to new-login-window
		driver.findElement(By.xpath("//span[@title='Google']")).click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle); 
        }
		//enter login+password
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId"))).sendKeys("testzipy1@gmail.com", Keys.ENTER);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).sendKeys("testzipy1testzipy1", Keys.ENTER);

		//back to the main window and wait for the login-window to close
		driver.switchTo().window(winHandleBefore);
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='topbar__forms-close']")));
		/*
		//Relogin by google:
				//press user button and disconnect 
				driver.manage().window().maximize();
				ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@class='topbar__user-link-no-name']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='topbar__user-dropdown-logout-anchor']"))).click();
				//click login, choose google again and wait for automatic login
				ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@data-user-form='popup_signin']")));
				driver.findElement(By.xpath("//span[@title='Google']")).click();
				new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='topbar__forms-close']")));
		*/		
				
		// if we logged in, there is a new button, named - אזור אישי
				Assert.assertTrue(driver.findElement(By.id("topbar")).getText().contains("אזור אישי"));
		
	}
	
	

	
}
