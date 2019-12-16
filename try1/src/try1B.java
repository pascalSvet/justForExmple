

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class try1B {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:/Users/Sveta/eclipse/java-2019-09/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		
		driver.get("https://www.zipy.co.il/");
		//close the pop-up window if exist
		if (driver.findElements(By.xpath("//button[@title='Close']")).size() != 0){
			driver.findElement(By.xpath("//button[@title='Close']")).click();
		}
		
		//press login button		
				JavascriptExecutor ex=(JavascriptExecutor)driver;
				ex.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@data-user-form='popup_signin']")));
				
		//enter login+password
				driver.findElement(By.id("i_signin-email")).sendKeys("vikos120989@yandex.com", Keys.TAB, "123456", Keys.ENTER);
				
				
		// perform search and enter the product
				String item = "rez-micro-usb-cable-usb-charging-cord-mobile-phone-nylon-xiaomi-android-samsung-for-hua-wei";
 				WebDriverWait wait = new WebDriverWait(driver, 20);
 				
 				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild"))).sendKeys(item, Keys.ENTER);
				wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@data-id='32995752928'][@data-position='1']")))).click();;

		// choose the color and the length
				//Thread.sleep(5000);
				//driver.findElement(By.id("accessibility-variation-select-Color")).click();
				WebElement color  = driver.findElement(
						By.xpath("/html/body/div[@role='dialog']/div[@class='featherlight-close-layer']/div[@class='featherlight-content quick-view']/div[@class='featherlight-content-wrap']/div/section//div[@class='buy-options']/table[@class='product__params']/tbody/tr[1]/td/div[@class='product__params-selection']/div[@class='field__field']/div[@class='select type-variations']/div[1]/div[@class='selectric']//span[@class='selectric-option-text']"));
				wait.until(ExpectedConditions.elementToBeClickable(color)).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[@role='dialog']/div[@class='featherlight-close-layer']//div[@class='featherlight-content-wrap']//section//div[@class='buy-options']/table[@class='product__params']/tbody/tr[1]/td/div[@class='product__params-selection']/div[@class='field__field']/div[@class='select type-variations']/div[1]/div[@class='selectric-items']/div/ul/li[2]//span[@class='selectric-option-text']")).click();
				WebElement length  = driver.findElement(
						By.xpath("/html/body/div[@role='dialog']/div[@class='featherlight-close-layer']/div[@class='featherlight-content quick-view']/div[@class='featherlight-content-wrap']/div/section//div[@class='buy-options']/table[@class='product__params']/tbody/tr[2]/td/div[@class='product__params-selection']/div[@class='field__field']/div[@class='select type-variations']/div[1]/div[@class='selectric']//span[@class='selectric-option-text']"));
				wait.until(ExpectedConditions.elementToBeClickable(length)).click();
				driver.findElement(By.xpath("/html/body/div[@role='dialog']/div[@class='featherlight-close-layer']//div[@class='featherlight-content-wrap']//section//div[@class='buy-options']/table[@class='product__params']/tbody/tr[2]/td/div[@class='product__params-selection']/div[@class='field__field']/div[@class='select type-variations']/div[1]/div[@class='selectric-items']/div/ul/li[4]//span[@class='selectric-option-text']")).click();
				/*Select color = new Select(driver.findElement(By.id("accessibility-variation-select-Color")));
				color.selectByIndex(1);*/
				
				//div[@id='wrapper']//main[@role='main']/section[@class='daily m--category m--plates']/div[@class='daily__slide']/div[1]/a[@href='https://www.zipy.co.il/p/אליאקספרס/rez-micro-usb-cable-usb-charging-cord-mobile-phone-nylon-xiaomi-android-samsung-for-hua-wei/32995752928/']
			/*	
				driver.findElement(By.id("accessibility-variation-select-Color")).click();
				driver.findElement(By.xpath("//li[@data-index='1']")).click();
				new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("accessibility-variation-select-Length"))).click();
				driver.findElement(By.xpath("//li[@data-index='3']")).click();
				
				//new Select(driver.findElement(By….));
				//buy
				driver.findElement(By.xpath("//div[@class='add-and-checkout']")).click();
		*/
	}


}
